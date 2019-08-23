package com.schoolChase.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.schoolChase.exception.ResourceNotFoundException;
import com.schoolChase.model.Mhs;
import com.schoolChase.repository.MhsRepository;


@RestController
@RequestMapping("/api/v5")

public class MhsController {
	@Autowired
	private MhsRepository mhsRepository;
	
	@GetMapping("/loginMhs")
	public List<Mhs> getAllMhs() {
		return mhsRepository.findAll();
	}

	@GetMapping("/login/{id}")
	public ResponseEntity<Mhs> getMhsById(@PathVariable(value = "id") Long mhsId)
			throws ResourceNotFoundException {
		Mhs mhs = mhsRepository.findById(mhsId)
				.orElseThrow(() -> new ResourceNotFoundException("Mahasiswa not found for this id :: " + mhsId));
		return ResponseEntity.ok().body(mhs);
	}

	@PostMapping("/registerMhs")
	public Mhs createMhs(@Valid @RequestBody Mhs mhs) {
		return mhsRepository.save(mhs);
	}
	
	@DeleteMapping("/login/{id}")
	public Map<String, Boolean> deleteMhs(@PathVariable(value = "id") Long mhsId)
			throws ResourceNotFoundException {
		Mhs mhs = mhsRepository.findById(mhsId)
				.orElseThrow(() -> new ResourceNotFoundException("Mahasiswa not found for this id :: " + mhsId));

		mhsRepository.delete(mhs);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}