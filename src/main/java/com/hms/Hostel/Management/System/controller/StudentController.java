package com.hms.Hostel.Management.System.controller;

import com.hms.Hostel.Management.System.model.Student;
import com.hms.Hostel.Management.System.model.StudentDto;
import com.hms.Hostel.Management.System.service.StudentRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping({"","/"})
    public String showStudent(Model model){
        List<Student> students = studentRepository.findAll();
        model.addAttribute("students", students);
        return "students/index";
    }

    @GetMapping("/add")
    public String showAddStudent(Model model){
        StudentDto studentDto = new StudentDto();
        model.addAttribute("studentDto", studentDto);
        return "students/addStudent";
    }

    @PostMapping("/add")
    public String addStudent(@Valid @ModelAttribute StudentDto studentDto, BindingResult bindingResult) throws IOException {

        if(bindingResult.hasErrors()){
            return "students/addStudent";
        }

        //Save Image

        MultipartFile imageFile = studentDto.getProfilePicture();
        String storageFileName = studentDto.getReg_No().replace("/","") +".jpg";
        try {
            String uploadDir = "public/images/";
            Path uploadPath = Paths.get(uploadDir);

            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            try (InputStream inputStream = imageFile.getInputStream()) {
                Files.copy(inputStream, Paths.get(uploadDir + storageFileName), StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (Exception e) {
                System.out.println("Exception: " + e.getMessage());
            }

        Student student = new Student();
        student.setReg_No(studentDto.getReg_No());
        student.setFirst_Name(studentDto.getFirst_Name());
        student.setLast_Name(studentDto.getLast_Name());
        student.setInitials(studentDto.getInitials());
        student.setID_No(studentDto.getID_No());
        student.setGender(studentDto.getGender());
        student.setEmail(studentDto.getEmail());
        student.setPhone(studentDto.getPhone());
        student.setFaculty(studentDto.getFaculty());
        student.setBatch(studentDto.getBatch());
        student.setAddress_House_No(studentDto.getAddress_House_No());
        student.setAddress_Street(studentDto.getAddress_Street());
        student.setAddress_Locality(studentDto.getAddress_Locality());
        student.setAddress_City(studentDto.getAddress_City());
        student.setAddress_Postcode(studentDto.getAddress_Postcode());
        student.setMedical_Condition(studentDto.getMedical_Condition());
        student.setNote(studentDto.getNote());
        student.setActive(studentDto.getActive());
        studentRepository.save(student);

        return "redirect:/students";
    }

    @GetMapping("/edit")
    public String showEditStudent(Model model, @RequestParam String reg_No){

        try{
            Student student = studentRepository.findById(reg_No).get();
            model.addAttribute("student", student);

            StudentDto studentDto = new StudentDto();
            studentDto.setReg_No(reg_No);
            studentDto.setFirst_Name(student.getFirst_Name());
            studentDto.setLast_Name(student.getLast_Name());
            studentDto.setInitials(student.getInitials());
            studentDto.setID_No(student.getID_No());
            studentDto.setGender(student.getGender());
            studentDto.setEmail(student.getEmail());
            studentDto.setPhone(student.getPhone());
            studentDto.setFaculty(student.getFaculty());
            studentDto.setBatch(student.getBatch());
            studentDto.setAddress_House_No(student.getAddress_House_No());
            studentDto.setAddress_Street(student.getAddress_Street());
            studentDto.setAddress_Locality(student.getAddress_Locality());
            studentDto.setAddress_City(student.getAddress_City());
            studentDto.setAddress_Postcode(student.getAddress_Postcode());
            studentDto.setMedical_Condition(student.getMedical_Condition());
            studentDto.setNote(student.getNote());
            studentDto.setActive(student.getActive());
            studentDto.setProfilePictureName(student.getReg_No().replace("/","") + ".jpg");

            model.addAttribute("studentDto", studentDto);

        }
        catch (Exception e){
            System.out.println("Exception: " + e.getMessage());
            return "redirect:/students";
        }

        return "students/editStudent";
    }

    @PostMapping("/edit")
    public String editStudent(Model model, @RequestParam String reg_No, @Valid @ModelAttribute StudentDto studentDto, BindingResult bindingResult) throws IOException {

        try{
            Student student = studentRepository.findById(reg_No).get();
            model.addAttribute("student", student);

            if(bindingResult.hasErrors()){
                return "students/editStudent";
            }

            if(!studentDto.getProfilePicture().isEmpty()){
                // delete old image
                String uploadDir = "public/images/";
                Path oldImagePath = Paths.get(uploadDir + studentDto.getProfilePictureName());

                try{
                    Files.delete(oldImagePath);
                }
                catch (Exception e){
                    System.out.println("Exception: " + e.getMessage());
                }

                // save new image
                MultipartFile imageFile = studentDto.getProfilePicture();
                String storageFileName = studentDto.getReg_No().replace("/","") +".jpg";

                try (InputStream inputStream = imageFile.getInputStream()) {
                    Files.copy(inputStream, Paths.get(uploadDir + storageFileName), StandardCopyOption.REPLACE_EXISTING);
                } catch (Exception e) {
                    System.out.println("Exception: " + e.getMessage());
                }
            }

            student.setReg_No(studentDto.getReg_No());
            student.setFirst_Name(studentDto.getFirst_Name());
            student.setLast_Name(studentDto.getLast_Name());
            student.setInitials(studentDto.getInitials());
            student.setID_No(studentDto.getID_No());
            student.setGender(studentDto.getGender());
            student.setEmail(studentDto.getEmail());
            student.setPhone(studentDto.getPhone());
            student.setFaculty(studentDto.getFaculty());
            student.setBatch(studentDto.getBatch());
            student.setAddress_House_No(studentDto.getAddress_House_No());
            student.setAddress_Street(studentDto.getAddress_Street());
            student.setAddress_Locality(studentDto.getAddress_Locality());
            student.setAddress_City(studentDto.getAddress_City());
            student.setAddress_Postcode(studentDto.getAddress_Postcode());
            student.setMedical_Condition(studentDto.getMedical_Condition());
            student.setNote(studentDto.getNote());
            student.setActive(studentDto.getActive());
            studentRepository.save(student);
        }
        catch (Exception e){
            System.out.println("Exception: " + e.getMessage());
        }

        return "redirect:/students";
    }

    @GetMapping("/deactivate")
    public String deactivateStudent(Model model, @RequestParam String reg_No){

        try{
            Student student = studentRepository.findById(reg_No).get();
            model.addAttribute("student", student);
            student.setActive(false);
            studentRepository.save(student);

        }
        catch (Exception e){
            System.out.println("Exception: " + e.getMessage());
            return "redirect:/students";
        }

        return "redirect:/students";
    }

}
