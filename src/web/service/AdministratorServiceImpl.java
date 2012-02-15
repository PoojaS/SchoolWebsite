package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.model.Administrator;
import web.repository.AdministratorRepository;

@Service
public class AdministratorServiceImpl implements AdministratorService {


    private AdministratorRepository administratorRepository;

    @Autowired
    public AdministratorServiceImpl(AdministratorRepository repository) {

        this.administratorRepository = repository;
    }

    @Transactional
    public boolean isValidCredentials(Administrator administrator) {

        Administrator admin = administratorRepository.getAdminFor(administrator.getUserName());
        if (admin == null)
            return false;
        if (admin.getPassword().equals(administrator.getPassword()))
            return true;
        return false;
    }
}
