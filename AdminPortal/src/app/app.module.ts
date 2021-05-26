import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RequestComponent } from './request/request.component';
import { LoginComponent } from './login/login.component';
import { NavbarComponent } from './navbar/navbar.component';
import { PrimaryTransactionComponent } from './primary-transaction/primary-transaction.component';
import { SavingsTransactionComponent } from './savings-transaction/savings-transaction.component';
import { SharedComponent } from './shared/shared.component';
import { UserAccountComponent } from './user-account/user-account.component';
import { FormsModule } from '@angular/forms';
import { LoginService } from './login.service';
import { UserService } from './user.service';
import { RequestService } from './request.service';

@NgModule({
  declarations: [
    AppComponent,
    RequestComponent,
    LoginComponent,
    NavbarComponent,
    PrimaryTransactionComponent,
    SavingsTransactionComponent,
    SharedComponent,
    UserAccountComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule
  ],
  providers: [
    LoginService,
    UserService,
    RequestService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
