import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../../../../service/user.service';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.less']
})
export class LoginFormComponent implements OnInit{
  ngOnInit(): void {
  }

  constructor(private router:Router, private userService:UserService){
  }

  loginUser(e){
    e.preventDefault(); 

    var username = e.target.elements[0].value;
    var password = e.target.elements[1].value;

    if(username=="" || password==""){
      return;
    }

    if(this.userService.isUserExistent(username, password)){
      this.userService.setUserLoggedIn;
      console.log("existent");
      this.router.navigate([""]);
    }

    return;
  }
}
