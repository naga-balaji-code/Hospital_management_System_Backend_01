package com.project.hospital_managemnet_system_E4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.hospital_managemnet_system_E4.dto.Report;
import com.project.hospital_managemnet_system_E4.dto.Room;
import com.project.hospital_managemnet_system_E4.service.RoomService;
import com.project.hospital_managemnet_system_E4.util.ResponseStructure;
@RestController
@CrossOrigin(origins = "http://localhost:5176")
public class RoomController 
{

	@Autowired
	RoomService roomService;

	@PostMapping("/saveRoom")
	public ResponseEntity<ResponseStructure<Room>> saveRoom(@RequestBody Room room) {
		return roomService.saveRoom(room);
	}

	@PutMapping("/updateRoomById")
	public ResponseEntity<ResponseStructure<Room>> updateRoomById (@RequestParam int oldRoomId,@RequestBody Room newRoom) {

		return roomService.updateRoomById(oldRoomId, newRoom);
	}

	@GetMapping("/fetchRoomById")
	public ResponseEntity<ResponseStructure<Room>> fetchRoomById(@RequestParam int roomId) {
		return roomService.fetchRoomById(roomId);
	}

	@DeleteMapping("/deleteRoomById")
	public ResponseEntity<ResponseStructure<Room>> deleteRoomById(@RequestParam int roomId) {

		return roomService.deleteRoomById(roomId);
	}

	@GetMapping("/fetchAllRoom")
	public List<Room> fetchAllRoom() {
		return roomService.fetchAllRoom();
	}
}
