import { JsonpClientBackend } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Appointment } from '../appointment';
import { RequestService } from '../request.service';

@Component({
  selector: 'app-request',
  templateUrl: './request.component.html',
  styleUrls: ['./request.component.css']
})
export class RequestComponent implements OnInit {

  appointmentList: Appointment[];

  constructor(private requestService: RequestService) {
    this.getAppointmentList();
   }

   getAppointmentList(){
     this.requestService.getAppointmentList().subscribe(
       res => {
         this.appointmentList = JSON.parse(JSON.parse(JSON.stringify(res))._body);
       },
       error => console.log(error)
     )
   }

   confirmAppointment(id: number){
     this.requestService.confirmAppointment(id).subscribe();
     location.reload();
   }

  ngOnInit(): void {
  }

}
