package web.backend;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import web.backend.Model.Patient;

@RestController
public class TestController {

    @GetMapping("/test")
    @CrossOrigin(origins = {"http://localhost:80", "http://localhost:5173"})
    public String testEndpoint() {
        return "Test endpoint is working!";
    }

    @GetMapping("/patients")
    @CrossOrigin(origins = {"http://localhost:80", "http://localhost:5173"})
    public Patient[] getPatients() {
        Patient p1 = new Patient(1, "Walter Almgren", "1932-04-12");
        Patient p2 = new Patient(2, "Theodor Wase", "2037-12-24");
        return new Patient[]{p1, p2};
    }

    @GetMapping("/patient")
    @CrossOrigin(origins = {"http://localhost:80", "http://localhost:5173"})
    public Patient getPatientById(@RequestParam int id) {
        // Create patients array
        Patient[] patients = new Patient[]{
                new Patient(1, "Walter Almgren", "1932-04-12"),
                new Patient(2, "Theodor Wase", "2037-12-24")
        };

        // Find the patient by id
        for (Patient p : patients) {
            if (p.getId() == id) {
                return p;
            }
        }

        // Fallback if not found
        return new Patient(0, "Unknown Patient", "0000-00-00");
    }
}
