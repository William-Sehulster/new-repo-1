pipeline {
    agent {
        label "hps-clin-builder"
    }

    options {
        // Only necessary if custom git config setup is required for a successful checkout
        // Usually indicated by git lfs errors with the default checkout
        skipDefaultCheckout true

        buildDiscarder(logRotator(numToKeepStr: '10'))
    }
    
    environment {
        REQUESTS_CA_BUNDLE='/etc/ssl/certs/ca-certificates.crt'

        // If using skipDefaultCheckout these will need to be set during/after that checkout instead of here
        // SANITIZED_BRANCH_NAME = sh(returnStdout: true, script: "echo $GIT_BRANCH | sed 's/[_/]/-/g' | sed 's/[^[:alnum:]-]//g' | sed 's/\\(-\\+\\)/-/g' | sed 's/feature/f/g' | sed 's/hotfix/hf/g' | sed 's/release/r/g' ").trim().take(40).toLowerCase()
        // SHORT_COMMIT_HASH = sh(returnStdout: true, script: "git log -n 1 --pretty=format:'%h'").trim()
        // REPO_URL = sh(returnStdout: true, script: "git remote get-url origin").trim()
    }
    stages {
        // Only necessary if custom git config setup is required for a successful checkout
        // Use in combination with 'skipDefaultCheckout' option
         stage('Prepare git') {
             steps {
                 sh '''
                     git config --list
                     git config --global http.postBuffer 1048576000

                     git config --global filter.lfs.smudge "git-lfs smudge --skip -- %f"
                     git config --global filter.lfs.process "git-lfs filter-process --skip"
                     git config --list
                 '''
             }
         }
         stage('Checkout') {
             steps {
                 script {
                     def scmVars = checkout scm

                     env.GIT_COMMIT = scmVars.GIT_COMMIT
                     env.GIT_BRANCH = scmVars.GIT_BRANCH
                     env.SANITIZED_BRANCH_NAME = sh(returnStdout: true, script: "echo $GIT_BRANCH | sed 's/[_/]/-/g' | sed 's/[^[:alnum:]-]//g' | sed 's/\\(-\\+\\)/-/g' | sed 's/feature/f/g' | sed 's/hotfix/hf/g' | sed 's/release/r/g' ").trim().take(40).toLowerCase()
                     env.SHORT_COMMIT_HASH = sh(returnStdout: true, script: "git log -n 1 --pretty=format:'%h'").trim()
                     env.REPO_URL = sh(returnStdout: true, script: "git remote get-url origin").trim()
                 }
             }
         }

        stage('CI Initialize') {
            steps {
                container('maven-3-8-1') {
                    sh '''
                        echo "Job configuration:"
                        echo ${BUILD_NUMBER}
                        echo ${GIT_BRANCH}
                        echo ${GIT_COMMIT}
                        echo ${SHORT_COMMIT_HASH}
                        mvn -v
                    '''
                    withCredentials([usernamePassword(credentialsId: 'jenkins-nexus-creds', passwordVariable: 'nexus_pw', usernameVariable: 'nexus_user')]) {
                        sh '''
                            sed -i "s/JENKINS_NEXUS_USER/${nexus_user}/g" ${WORKSPACE}/pipeline/settings.xml
                            sed -i "s/JENKINS_NEXUS_PASSWORD/${nexus_pw}/g" ${WORKSPACE}/pipeline/settings.xml
                        '''
                    }
                    // !! IMPORTANT !! Set the main parent pom path HERE
                    sh '''
                        mkdir .mvn
                        echo '-Djavax.net.ssl.trustStore=/etc/pki/ca-trust/extracted/java/cacerts --settings pipeline/settings.xml -B -e -f pom.xml' > .mvn/maven.config
                    '''
                }

                echo "Set commit state as 'pending'"
                container('dots-utility') {
                    withCredentials([usernamePassword(credentialsId: 'jenkins-status', passwordVariable: 'status_pw', usernameVariable: 'status_user')]) {
                        sh '''
                            export STATUS_TOKEN=${status_pw}
                            export BUILD_STATE=pending
                            python pipeline/status.py
                        '''
                    }
                }
            }
        }
        
        // Set the artifact changelist based on the branch
        // the final artifact version will be ${version}${changelist} where ${version} comes from the top level pom
        // master will have NO changelist (standard release version)
        // dev will have '-SNAPSHOT'' (snapshot version)
        // release/* and hotfix/* will have '.${BUILD_NUMBER}-${short_commit_hash}'
        // all OTHER branches will have '-${build_number}-${branch_name}-${short_commit_hash}-SNAPSHOT'
        stage('Set App Version') {
            environment {
                RELEASE_CHANGELIST = ".$BUILD_NUMBER-$SHORT_COMMIT_HASH"
                DEV_CHANGELIST = "-SNAPSHOT"
                PREVIEW_VERSION = "-$BUILD_NUMBER-$SANITIZED_BRANCH_NAME-$SHORT_COMMIT_HASH-SNAPSHOT"
            }

            stages {
                stage('Set Version (master)') {
                    when {
                        branch 'master'
                    }
                    steps {
                        container('maven-3-8-1') {
                            sh '''
                                echo '' > ${WORKSPACE}/app_changelist
                            '''
                        }
                    }
                }
                stage('Set Version (release & hotfix)') {
                    when {
                        anyOf {
                            branch 'release/*'
                            branch 'hotfix/*'
                        }
                    }
                    steps {
                        container('maven-3-8-1') {
                            sh '''
                                echo "${RELEASE_CHANGELIST}" > ${WORKSPACE}/app_changelist
                            '''
                        }
                    }
                }
                stage('Set Version (dev)') {
                    when {
                        branch 'dev'
                    }
                    steps {
                        container('maven-3-8-1') {
                            sh '''
                                echo "${DEV_CHANGELIST}" > ${WORKSPACE}/app_changelist
                            '''
                        }
                    }
                }
                stage('Set Version (other)') {
                    when {
                        not { anyOf {
                            branch 'master'
                            branch 'dev'
                            branch 'release/*'
                            branch 'hotfix/*'
                        } }
                    }
                    steps {
                        container('maven-3-8-1') {
                            sh '''
                                echo "${PREVIEW_VERSION}" > ${WORKSPACE}/app_changelist
                            '''
                        }
                    }
                }

            }
        }
        stage('Build') {
            steps {
                container('maven-3-8-1') {
                    sh '''
                        APP_CHANGELIST=\$(cat ${WORKSPACE}/app_changelist)
                        mvn -Dchangelist=${APP_CHANGELIST} clean install
                    '''
                }
            }
        }

        //  For Checkstyle
        // stage('Checkstyle') {
        //     steps {
        //         container('maven-3-8-1') {
        //             sh '''
        //                 APP_CHANGELIST=\$(cat ${WORKSPACE}/app_changelist)
        //                 mvn -Dchangelist=${APP_CHANGELIST} checkstyle:checkstyle
        //             '''
        //         }
        //     }
        // }

        stage('Publish artifacts') {
            when {
                anyOf {
                    branch 'master'
                    branch 'dev'
                    branch 'release/*'
                    branch 'hotfix/*'
                }
            }
            steps {
                container('maven-3-8-1') {
                    sh '''
                        APP_CHANGELIST=\$(cat ${WORKSPACE}/app_changelist)
                        mvn -Dchangelist=${APP_CHANGELIST} -DskipTests deploy
                    '''
                }
            }
        }
    }
    post {
        always {
            echo "Post always stage."
            // default to error state - if success or failure will be overwritten below
            sh "echo 'error' > ${WORKSPACE}/result"

            junit testResults: '**/target/surefire-reports/TEST-*.xml'
            
            discoverGitReferenceBuild defaultBranch : 'dev', latestBuildIfNotFound: true
            recordIssues enabledForFailure: true, tools: [mavenConsole(), java()]
            
            // For Checkstyle
            // recordIssues enabledForFailure: true, tool: checkStyle()
        }
        success {
            archiveArtifacts artifacts: '**/target/*.jar,**/target/*.ear,**/target/*.war', allowEmptyArchive: true, fingerprint: true
            sh "echo 'success' > ${WORKSPACE}/result"
        }
        failure {
            echo "Build failed."
            sh "echo 'failure' > ${WORKSPACE}/result"
        }
        cleanup {
            echo "Set commit state in GitHub"
            container('dots-utility') {
                withCredentials([usernamePassword(credentialsId: 'jenkins-status', passwordVariable: 'status_pw', usernameVariable: 'status_user')]) {
                    sh '''
                        export STATUS_TOKEN=${status_pw}
                        export BUILD_STATE=\$(cat ${WORKSPACE}/result)
                        python pipeline/status.py
                    '''
                }
            }
        }
    }
}