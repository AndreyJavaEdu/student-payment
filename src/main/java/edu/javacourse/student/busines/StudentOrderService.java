package edu.javacourse.student.busines;

import edu.javacourse.student.dao.StreetRepository;
import edu.javacourse.student.dao.StudentRepository;
import edu.javacourse.student.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentOrderService {
    private static final Logger LOGGER = LoggerFactory.getLogger(StudentOrderService.class);
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StreetRepository streetRepository;

    @Transactional
    public void testSave() {
        StudentOrder so = new StudentOrder();
        so.setHusband(buildPerson(false));
        so.setWife(buildPerson(true));
        studentRepository.save(so);

    }

    @Transactional
    public void testGet() {
        List<StudentOrder> sos = studentRepository.findAll();
        LOGGER.info(sos.get(0).getWife().getGivenName());
    }

    private Adult buildPerson(boolean wife) {
        Adult p = new Adult();
        p.setDateOfBirthday(LocalDate.now());
        Address a = new Address();
        a.setPostCode("19000000");
        a.setBuilding("21");
        a.setExtension("B");
        a.setApartment("199");
        Street one = streetRepository.getOne(1L);
        a.setStreet(one);
        p.setAddress(a);
        if (wife) {
            p.setSurName("Рюрик");
            p.setGivenName("Марфа");
            p.setPatronymic("Васильевна");
            p.setPassportSerial("WIFE_S");
            p.setPassportNumber("WIFE_N");
            p.setIssueDate(LocalDate.now());
        } else {
            p.setSurName("Рюрик");
            p.setGivenName("Иван");
            p.setPatronymic("Васильевич");
            p.setPassportSerial("HUSBAND_S");
            p.setPassportNumber("HUSBAND_N");
            p.setIssueDate(LocalDate.now());
        }

        return p;
    }
}
