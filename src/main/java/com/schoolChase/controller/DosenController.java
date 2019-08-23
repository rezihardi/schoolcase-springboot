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
import com.schoolChase.model.Dosen;
import com.schoolChase.repository.DosenRepository;


@RestController
@RequestMapping("/api/v4")

public class DosenController {
	@Autowired
	private DosenRepository dosenRepository;
	
	@GetMapping("/loginDosen")
	public List<Dosen> getAllDosen() {
		return dosenRepository.findAll();
	}

	@GetMapping("/login/{id}")
	public ResponseEntity<Dosen> getDosenById(@PathVariable(value = "id") Long dosenId)
			throws ResourceNotFoundException {
		Dosen dosen = dosenRepository.findById(dosenId)
				.orElseThrow(() -> new ResourceNotFoundException("Dosen not found for this id :: " + dosenId));
		return ResponseEntity.ok().body(dosen);
	}

	@PostMapping("/registerDosen")
	public Dosen createDosen(@Valid @RequestBody Dosen dosen) {
		return dosenRepository.save(dosen);
	}
	
	@DeleteMapping("/login/{id}")
	public Map<String, Boolean> deleteDosen(@PathVariable(value = "id") Long dosenId)
			throws ResourceNotFoundException {
		Dosen dosen = dosenRepository.findById(dosenId)
				.orElseThrow(() -> new ResourceNotFoundException("Dosen not found for this id :: " + dosenId));

		dosenRepository.delete(dosen);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}