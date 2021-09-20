import os
import requests
import re

token = os.getenv('STATUS_TOKEN')
build_url = os.getenv('BUILD_URL')
sha = os.getenv('GIT_COMMIT')
state = os.getenv('BUILD_STATE')
repo_url = os.getenv('REPO_URL')

m = re.match(r'^(https|git)(://|@)([^/:]+)[/:]([^/:]+)/(.+).git$', repo_url)

hostname = m.group(3)
git_user = m.group(4)
repo_name = m.group(5)

url = f'https://api.{hostname}/repos/{git_user}/{repo_name}/statuses/{sha}'

print(url)

r = requests.post(url, auth=('', token), 
    headers={'Accept': 'application/vnd.github.v3+json'}, 
    json={'context': 'Jenkins build',
      'target_url': build_url,
      'state': state
    }
)
r.raise_for_status()