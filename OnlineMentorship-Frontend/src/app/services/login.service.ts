import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";

const  baseUrl = 'http://localhost:8091/api';
@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http:HttpClient) { }

  public login(loginData: any){
    console.log("posting data")
    return this.http.post(`${baseUrl}/login`, loginData);
  }

  /**
   * Storing token in local storage
   */
  public storeToken(token: string){
    localStorage.setItem("token",token);
    return true;
  }

  public getCurrentUser(){

    console.log(this.http.get(`${baseUrl}/currentUser`))
    return this.http.get(`${baseUrl}/currentUser`);
  }

  //isLogin: user is logged in or not

  public isLoggedIn():boolean{
    let tokenStr = localStorage.getItem("token");
    return !(tokenStr == undefined || tokenStr == '' || tokenStr == null);
  }

  // logout: remove token from the localstorage
  public logout():boolean{
    localStorage.removeItem("token");
    localStorage.removeItem("user");
    localStorage.removeItem('currentUser')
    return true;
  }

  // return token
  public getToken(){
    return localStorage.getItem("token");
  }

  public setUser(user:any){
    localStorage.setItem(
      'user', JSON.stringify(user)
    );
    return true;
  }
  public getUserRole() {
    return localStorage.getItem("role");
  }
  public setUserRole(){
    let user = this.getUser();
    localStorage.setItem("role",user.authorities[0].authority)
    return true;
  }
  public getUser() {
    let userStr = localStorage.getItem('user');
    if (userStr != null) {
      return JSON.parse(userStr);
    } else {
      this.logout();
      return null;
    }
  }

}
