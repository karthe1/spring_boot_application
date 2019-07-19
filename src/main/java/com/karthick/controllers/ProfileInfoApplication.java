package com.karthick.controllers;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
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
public class  ProfileInfoApplication {

	@Autowired
	ProfileRepository profileRepository;
	
	@GetMapping("/getProfiles")
	public Collection<Profile> getProfileInfo() {
		return profileRepository.findAll();
	}
    
	@GetMapping("/getProfiles/{id}")
	public Profile getProfileInfoById(@PathVariable Long profileId) {
		return profileRepository.findOne(profileId);
	}
    
	@PostMapping("/addProfile")
	public Profile addProfileInfo(@RequestBody Map<String, String> profileInfo) {

		String profileName = profileInfo.get("profileName");
		String firstName = profileInfo.get("firstName");
		String lastName = profileInfo.get("lastName");
		Profile p = new Profile(profileName, firstName, lastName);
		return profileRepository.save(p);
	}
    
	@PutMapping("/updateProfile/{id}")
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
	public boolean delete(@PathVariable String id) {
		Long blogId = Long.parseLong(id);
		profileRepository.delete(blogId);
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(ProfileInfoApplication.class, args);
	}

}
