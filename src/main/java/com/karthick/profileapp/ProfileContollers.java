package com.karthick.profileapp;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class ProfileContollers {

	@Autowired
	ProfileRepository profileRepository;
	
	@GetMapping("/getProfiles")
	/**
	 * Resource URI for retrieving all the profile information. 
	 * 
	 * @return
	 */
	public Collection<Profile> getProfileInfo() {
		return profileRepository.findAll();
	}
    
	@GetMapping("/getProfiles/{id}")
	/**
	 * Resource URI for retrieving specified the profile information based on profile ID.
	 * 
	 * @param id
	 * @return
	 */
	public Profile getProfileInfoById(@PathVariable String id) {
		Long blogId = Long.parseLong(id);
		return profileRepository.findOne(blogId);
	}
    
	@PostMapping("/addProfile")
	/**
	 * Resource URI for creating a profile information. 
	 * 
	 * @param profileInfo
	 * @return
	 */
	public Profile addProfileInfo(@RequestBody Map<String, String> profileInfo) {

		String profileName = profileInfo.get("profileName");
		String firstName = profileInfo.get("firstName");
		String lastName = profileInfo.get("lastName");
		Profile p = new Profile(profileName, firstName, lastName);
		return profileRepository.save(p);
	}
    
	@PutMapping("/updateProfile/{id}")
	/**
	 * Resource URI for updating a profile information.
	 * 
	 * @param id
	 * @param profileInfo
	 * @return
	 */
	public Profile update(@PathVariable String id, @RequestBody Map<String, String> profileInfo) {
		Long blogId = Long.parseLong(id);
		// getting blog
		Profile profile = profileRepository.findOne(blogId);
		Set<Entry<String, String>> s = profileInfo.entrySet();
		for (Entry<String, String> entry : s) {
			if (entry.getKey().equals("profileName")) {
				profile.setProfileName(profileInfo.get("profileName"));
			} else if (entry.getKey().equals("firstName")) {
				profile.setFirstName(profileInfo.get("firstName"));
			} else if (entry.getKey().equals("lastName")) {
				profile.setLastName(profileInfo.get("lastName"));
			}
		}
		return profileRepository.save(profile);
	}

	@DeleteMapping("/deleteProfile/{id}")
	/**
	 * Resource URI for deleting a profile information.
	 * 
	 * @param id
	 * @return
	 */
	public boolean delete(@PathVariable String id) {
		Long blogId = Long.parseLong(id);
		profileRepository.delete(blogId);
		return true;
	}

}
