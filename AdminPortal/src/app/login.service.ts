import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient) { }

  sendCredential(username: string, password: string){
    let url = "http://localhost:8085/index";
    let params = 'username='+username+'&password='+password;
    let headers = new HttpHeaders(
      {
        'content-type': 'application/x-www-form-urlencoded'
      });
      return this.http.post(url, params, {headers: headers, withCredentials: true});
  }

  logout(){
    let url="http://localhost:8085/logout";
    return this.http.get(url, {withCredentials: true});
  }
}
