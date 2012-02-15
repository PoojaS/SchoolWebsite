package web.service;

import web.model.Administrator;

public interface AdministratorService {
    public boolean isValidCredentials(Administrator administrator);
}
