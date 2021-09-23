import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {pluck} from 'rxjs/operators';
import {environment} from '../../environments/environment';
import {Router} from '@angular/router';
import {OAuthService} from 'angular-oauth2-oidc';

const host = environment.apiUrl;

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(
    private router: Router, private http: HttpClient, private oauthService: OAuthService){
    this.oauthService.configure({
      loginUrl: 'http://localhost:8081/oauth/authorize',
      redirectUri: 'http://localhost:4200',
      clientId: 'chatApp',
      scope: 'read',
      oidc: false
    })
    this.oauthService.setStorage(localStorage);
    this.oauthService.tryLogin({});
  }

  obtainAccessToken(){
    this.oauthService.initImplicitFlow();
    console.log(this.oauthService.getAccessToken());
  }

  getUser(): Observable<any>{
    var headers = new HttpHeaders({'Content-type': 'application/x-www-form-urlencoded; charset=utf-8', 'Authorization': 'Bearer ' + this.oauthService.getAccessToken()});
    return this.http.get('http://localhost:8080/backend/users/extra', {headers: headers});
  }

  // getResource(resourceUrl) : Observable<any>{
  //   var headers = new HttpHeaders({'Content-type': 'application/x-www-form-urlencoded; charset=utf-8', 'Authorization': 'Bearer ' + this.oauthService.getAccessToken()});
  //   return this._http.get(resourceUrl, { headers: headers })
  //     .catch((error:any) => Observable.throw(error.json().error || 'Server error'));
  // }

  isLoggedIn(){
    console.log(this.oauthService.getAccessToken());
    if (this.oauthService.getAccessToken() === null){
      return false;
    }
    return true;
  }

  logout() {
    this.oauthService.logOut();
    location.reload();
  }
}
