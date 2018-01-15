import{ Injectable } from '@angular/core';

@Injectable()
export class UserService{
    private isUserLoggedIn;
    private username="";

    constructor(){
        this.isUserLoggedIn = false;
    }

    isUserExistent(username:string, password:string){
        if(username=="user" && password=="pass"){
            this.username=username;
            return true;
        }
        return false;
    }

    isUserNameTaken(username:string){
        if(username=="user"){
            return true;
        }
        return false
    }

    registerNewUser(username:string, password:string){

    }

    authenticate(){

    }

    setUserLoggedIn(){
        this.isUserLoggedIn = true;
    }

    getUserLoggedIn(){
        return this.isUserLoggedIn;
    }

    getUserName(){
        return this.username;
    }
}