package com.innova.controller;

import com.innova.dto.LoginDto;
import com.innova.dto.RegisterDto;
import com.innova.entity.UserEntity;
import com.innova.repository.IUserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@RequestMapping(value = "WoW") // usercontroller'in etkileyecegi url'ler "WoW" PATH'inin altında bulunur yani usercontrollerdeki methodlar http://localhost:8080/WoW/... seklinde yazilmali
@Log4j2
public class UserController {

    @Autowired
    IUserRepository iUserRepository;

    //MVC = Model View Control. Model = View yardımıyla (ekran, arayüz olabilir) kullanıcı tarafından girilen dataların tutulduğu veya Database'den alınan verilerin
    //view ekranında gösterilmesini saglayan bir objedir. Model yapısı DB ile sürekli iletişim halindedir. View'den girdigimiz degerleri Database'ye aktarmaya yarayan,
    //database'den aldıgı verileri View üzerinde kullanıcılara göstermeye yarayan bir yapıdır.

    //Controller = Model ile view arasındaki baglantıyı saglayan yapidir.

    //View = arayüz, dataları gorebildigimiz veya data girebildigimiz ekran

    //@GetMapping anotasyonu ile mapping ya da tarayıcıda web pageleri olusturacak ya sayfa url'sini olusturmus oluruz. GetMapping'de yazan deger ile, Bu anotasyonun etkiledigi
    //method cagirilir ve bu method sayesinde model ile view arasında iletisim, veri transferi saglanabilir.


    // http://localhost:8080/WoW/register
    @GetMapping("register")
    public String getRegister(Model model){
        model.addAttribute("register_form", new RegisterDto());
        return "register";
    }
    // http://localhost:8080/WoW/login

    @GetMapping("login")
    public String getLogin(Model model){
        model.addAttribute("login_form", new LoginDto());
        return "login";
    }

    // http://localhost:8080/WoW/register
    @PostMapping("register")
    public String postRegister(@Valid @ModelAttribute("register_form") RegisterDto registerDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("Hata");

            log.info(registerDto);

            return "register";
        }
        //Dto olarak alınan veri maplenerek Entity'e eklendi
        UserEntity userEntity = UserEntity
                .builder().userId(0L).userName(registerDto.getUserName()).userPassword(registerDto.getUserPassword())
                .userEmail(registerDto.getUserEmail()).userRace(registerDto.getUserRace()).build();

        iUserRepository.save(userEntity);

        log.info(registerDto);
        return "redirect:login";
    }

    // http://localhost:8080/WoW/login
    @PostMapping("login")
    public String postLogin(@Valid @ModelAttribute("login_form") LoginDto loginDto, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            log.error("Hata var");
            log.info(loginDto);
            return "login";
        }

        //databaseden kontrol edilecek alan
        log.info(loginDto);
        return "hosgeldin";
    }

}
