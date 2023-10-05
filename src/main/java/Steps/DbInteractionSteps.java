package Steps;

import DB.DbUser;
import DB.SQLQuery;
import Pages.RegistartionPage;
import io.qameta.allure.Step;

import java.util.Map;

public class DbInteractionSteps {
    RegistartionPage registartionPage = new RegistartionPage();

    @Step("Inserting user data into database")
    public int insertUserIntoDatabase(String fName, String lName, String phone, String email, java.sql.Date birthDate, String password ) {
        return SQLQuery.insertUser(fName, lName, phone, email, birthDate, password );
    }

    @Step("Inserting user data into database")
    public DbInteractionSteps sendUserInfoById(int id) {
        Map<String, String> userData = DbUser.fetchUserById(id);
        registartionPage.firstName.sendKeys(userData.get("firstName"));
        registartionPage.lastName.sendKeys(userData.get("lastName"));
        registartionPage.phoneNumber.sendKeys(userData.get("phone"));
        registartionPage.email.sendKeys(userData.get("email"));
        registartionPage.birthDate.sendKeys(userData.get("dateOfBirth"));
        registartionPage.password.sendKeys(userData.get("password"));
        registartionPage.confirmPassword.sendKeys(userData.get("password"));
        return this;
    }

    @Step("Deleting user by id from Database")
    public DbInteractionSteps deleteUserByIdFromDatabase(int delById){
        SQLQuery.deleteUserById(delById);
        return this;
    }
}
