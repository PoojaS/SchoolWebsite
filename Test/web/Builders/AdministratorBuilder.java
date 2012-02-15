package web.Builders;

import web.model.Administrator;


public class AdministratorBuilder extends Administrator {

    public AdministratorBuilder withDefaults() {
        withUserName("Pooja");
        withPassword("abcd1234");
        return this;
    }

    public AdministratorBuilder withPassword(String password) {
        setPassword(password);
        return this;
    }

    public AdministratorBuilder withUserName(String userName) {
        setUserName(userName);
        return this;
    }

}
