import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class RequestService {

  constructor(private http:HttpClient) { }

  getAppointmentList(){
    let url = "http://localhost:8085/api/request/all";
    return this.http.get(url, {withCredentials: true});
  }

  confirmAppointment(id: number){
    let url = "http://localhost:8085/api/request/"+id+"/confirm";
    return this.http.get(url, {withCredentials: true});
  }
}
