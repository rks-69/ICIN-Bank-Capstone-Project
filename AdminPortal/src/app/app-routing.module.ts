import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { PrimaryTransactionComponent } from './primary-transaction/primary-transaction.component';
import { RequestComponent } from './request/request.component';
import { SavingsTransactionComponent } from './savings-transaction/savings-transaction.component';
import { UserAccountComponent } from './user-account/user-account.component';

const routes: Routes = [
  {
    path: '',
    redirectTo: '/login',
    pathMatch: 'full'
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'userAccount',
    component: UserAccountComponent
  },
  {
    path: 'primaryTransaction/:username',
    component: PrimaryTransactionComponent
  },
  {
    path: 'savingsAccountTransaction/:username',
    component: SavingsTransactionComponent
  },
  {
    path: 'request',
    component: RequestComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
