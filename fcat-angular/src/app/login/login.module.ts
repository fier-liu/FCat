import {NgModule} from "@angular/core";
import {BrowserModule} from "@angular/platform-browser";
import {FormsModule} from "@angular/forms";
import {HttpModule, JsonpModule} from "@angular/http";
import {Config} from "../app-config";
import {TUserModule} from "../baseinfo/t-user.module";
import {LoginComponent} from "./login.component";
import {LoginRoutingModule} from "./login-routing.module";
import {LoginService} from "./Login.service";

@NgModule({
  imports: [BrowserModule, FormsModule,
    LoginRoutingModule,
    HttpModule,
    JsonpModule,
    TUserModule
  ],
  declarations: [LoginComponent
     ],
  providers: [
    Config,LoginService
  ]
})
export class LoginModule {

}
