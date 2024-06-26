import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NZ_I18N } from 'ng-zorro-antd/i18n';
import { en_US } from 'ng-zorro-antd/i18n';
import { registerLocaleData } from '@angular/common';
import en from '@angular/common/locales/en';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { LayoutDefaultComponent } from './layout/layout-default/layout-default.component';
import { LayoutPrivateComponent } from './layout/layout-private/layout-private.component';
import { HeaderComponent } from './components/header/header.component';
import { HomeComponent } from './page/home/home.component';
import { LoginComponent } from './page/login/login.component';
import { ManagerScoreComponent } from './page/manager-score/manager-score.component';
import { NzLayoutModule } from 'ng-zorro-antd/layout';

registerLocaleData(en);

@NgModule({
  declarations: [
    AppComponent,
    LayoutDefaultComponent,
    LayoutPrivateComponent,
    HeaderComponent,
    HomeComponent,
    LoginComponent,
    ManagerScoreComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    NzLayoutModule

  ],
  providers: [
    { provide: NZ_I18N, useValue: en_US }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
