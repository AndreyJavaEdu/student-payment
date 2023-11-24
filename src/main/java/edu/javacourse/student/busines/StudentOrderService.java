package edu.javacourse.student.busines;

import edu.javacourse.student.dao.*;
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
    @Autowired
    private StudentOrderStatusRepository daoStatus;
    @Autowired
    private PassportOfficeRepository daoPassportOffice;
    @Autowired
    private UniversityRepository daoUniversity;
    @Autowired
    private RegisterOfficeRepository daoRegisterOffice;
    @Autowired
    private StudentOrderChildRepository childRepository;

    @Transactional
    public void testSave() {
        StudentOrder so = new StudentOrder();
        so.setStudentOrderDate(LocalDate.now());
        so.setStudentOrderStatus(daoStatus.getOne(1L));

        so.setHusband(buildPerson(false));
        so.setWife(buildPerson(true));

        so.setCertificateNumber("CERTIFICATE");
        so.setRegisterOffice(daoRegisterOffice.getOne(1L));
        so.setMarriageDate(LocalDate.now());
        studentRepository.save(so);

        StudentOrderChild soc = buildChild(so);

        childRepository.save(soc);
    }

    @Transactional
    public void testGet() {
        List<StudentOrder> sos = studentRepository.findAll();
        LOGGER.info(sos.get(0).getWife().getGivenName());
        LOGGER.info(sos.get(0).getChildren().get(0).getGivenName());
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
            p.setPassportOffice(daoPassportOffice.getOne(1L));
            p.setStudentNumber("12345");
            p.setUniversity(daoUniversity.getOne(1L));
        } else {
            p.setSurName("Рюрик");
            p.setGivenName("Иван");
            p.setPatronymic("Васильевич");
            p.setPassportSerial("HUSBAND_S");
            p.setPassportNumber("HUSBAND_N");
            p.setIssueDate(LocalDate.now());
            p.setPassportOffice(daoPassportOffice.getOne(1L));
            p.setStudentNumber("67890");
            p.setUniversity(daoUniversity.getOne(1L));
        }

        return p;
    }

    private StudentOrderChild buildChild(StudentOrder so) {
        StudentOrderChild p = new StudentOrderChild();
        p.setStudentOrder(so);
        p.setDateOfBirthday(LocalDate.now());
        Address a = new Address();
        a.setPostCode("19000000");
        a.setBuilding("21");
        a.setExtension("B");
        a.setApartment("199");
        Street one = streetRepository.getOne(1L);
        a.setStreet(one);
        p.setAddress(a);
        p.setSurName("Рюрик");
        p.setGivenName("Дмитрий");
        p.setPatronymic("Иванович");
        p.setCertificateDate(LocalDate.now());
        p.setCertificateNumber("BIRTH N");
        p.setRegisterOffice(daoRegisterOffice.getOne(1L));
        return p;
    }
}
