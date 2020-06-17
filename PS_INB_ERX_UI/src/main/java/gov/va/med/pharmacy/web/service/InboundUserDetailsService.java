package gov.va.med.pharmacy.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gov.va.med.pharmacy.persistence.model.VaUser;
import gov.va.med.pharmacy.persistence.service.UserService;



@Service("inboundUserDetailsService")
public class InboundUserDetailsService implements UserDetailsService{

	@Autowired
	private UserService userService;
	
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String networkID)	 {
		
		VaUser user = userService.findByVAUserID(networkID);
		
		
		if(user==null){
			
			
			return new User(networkID, "",	true, true, true, true, getViewOnlyGrantedAuthorities());
		}
		
		 if(user!=null && user.getIsEnabled() == false){
		
			 return new User(user.getVaUserid(), "",	 (false), true, true, true, getGrantedAuthorities(user));
		
		 }
		
		
			return new User(user.getVaUserid(), "",	 (true), true, true, true, getGrantedAuthorities(user));
	}

	
	private List<GrantedAuthority> getGrantedAuthorities(VaUser user){
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
        if(user.getIsPharmMgr()){
        	
        	authorities.add(new SimpleGrantedAuthority("ROLE_PHARM_MGR"));
        }
        
        if(user.getIsPbmAdmn()){
        	authorities.add(new SimpleGrantedAuthority("ROLE_PBM_ADMN"));
        }
        
        if(user.getIsPharmUser()){
        	authorities.add(new SimpleGrantedAuthority("ROLE_PHARM_USER"));
        }
        
        if(user.getIsSystemAdmn()){
        	authorities.add(new SimpleGrantedAuthority("ROLE_SYSTEM_ADMN"));
        }
        
        if(authorities.isEmpty()){
        	authorities.add(new SimpleGrantedAuthority("ROLE_READONLY"));
        }
        
		return authorities;
	}
	
	private List<GrantedAuthority> getViewOnlyGrantedAuthorities(){
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
						
		authorities.add(new SimpleGrantedAuthority("ROLE_READONLY"));
		
		
		return authorities;
	}
	
}
