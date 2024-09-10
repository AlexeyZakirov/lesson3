import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class demoQaTest {

    @BeforeAll
    static void setUp(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    public void fillAllFieldsTest(){
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        //Name
        $("#firstName").setValue("Alexey");
        $("#lastName").setValue("Zakirov");
        //Email
        $("#userEmail").setValue("azakirov@mail.ru");
        //Gender
        $("[for = gender-radio-1]").click();
        //Mobile
        $("#userNumber").setValue("1111111111");
        //Date of Birth
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("2000");
        $(".react-datepicker__day--003").click();
        //Subjects
        $(".subjects-auto-complete__value-container--is-multi").click();
        $("#subjectsInput").setValue("m");
        $("#react-select-2-option-0").click();
        //Hobbies
        $("[for=hobbies-checkbox-1]").click();
        $("[for=hobbies-checkbox-3]").click();
        //Picture
        $("#uploadPicture").uploadFromClasspath("cat.png");
        //Current Address
        $("#currentAddress").setValue("3204 Canyon Lake Drive");
        //State and City
        $("#react-select-3-input").setValue("n");
        $("#react-select-3-option-0").click();
        $("#react-select-4-input").setValue("d");
        $("#react-select-4-option-0").click();
        //Submit
        $("#submit").click();

        $(".table tbody tr:nth-child(1) td:nth-child(2)").shouldHave(text("Alexey Zakirov"));
        $(".table tbody tr:nth-child(2) td:nth-child(2)").shouldHave(text("azakirov@mail.ru"));
        $(".table tbody tr:nth-child(3) td:nth-child(2)").shouldHave(text("Male"));
        $(".table tbody tr:nth-child(4) td:nth-child(2)").shouldHave(text("1111111111"));
        $(".table tbody tr:nth-child(5) td:nth-child(2)").shouldHave(text("03 July,2000"));
        $(".table tbody tr:nth-child(6) td:nth-child(2)").shouldHave(text("Maths"));
        $(".table tbody tr:nth-child(7) td:nth-child(2)").shouldHave(text("Sports, Music"));
        $(".table tbody tr:nth-child(8) td:nth-child(2)").shouldHave(text("cat.png"));
        $(".table tbody tr:nth-child(9) td:nth-child(2)").shouldHave(text("3204 Canyon Lake Drive"));
        $(".table tbody tr:nth-child(10) td:nth-child(2)").shouldHave(text("NCR Delhi"));

        sleep(5000);
    }
}
