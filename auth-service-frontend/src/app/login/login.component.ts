import { Component, OnInit } from '@angular/core';
import {AuthService} from '../_service/auth.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  public isLoggedIn = false;
  user: any;

  constructor(
    private authService: AuthService
  ){}

  ngOnInit(): void{
    this.isLoggedIn = this.authService.isLoggedIn();
    this.authService.getUser().subscribe(data =>
    {
      this.user = data;
      console.log(this.user.user_name);
    });
  }
  login(): void {
    this.authService.obtainAccessToken();
  }
  logout(): void {
    this.authService.logout();
  }

}
