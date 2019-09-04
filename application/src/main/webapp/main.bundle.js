webpackJsonp(["main"],{

/***/ "./src/$$_lazy_route_resource lazy recursive":
/***/ (function(module, exports) {

function webpackEmptyAsyncContext(req) {
	// Here Promise.resolve().then() is used instead of new Promise() to prevent
	// uncatched exception popping up in devtools
	return Promise.resolve().then(function() {
		throw new Error("Cannot find module '" + req + "'.");
	});
}
webpackEmptyAsyncContext.keys = function() { return []; };
webpackEmptyAsyncContext.resolve = webpackEmptyAsyncContext;
module.exports = webpackEmptyAsyncContext;
webpackEmptyAsyncContext.id = "./src/$$_lazy_route_resource lazy recursive";

/***/ }),

/***/ "./src/app/app.component.html":
/***/ (function(module, exports) {

module.exports = "<nav class=\"navbar\" style=\"margin-bottom: 0px; background-color: aliceblue;\" *ngIf = \"disableNavBar\">\r\n  <div class=\"container-fluid\">\r\n    <div class=\"navbar-header\">\r\n      <button type=\"button\" class=\"navbar-toggle collapsed\" data-toggle=\"collapse\" data-target=\"#navbar\" aria-expanded=\"false\" aria-controls=\"navbar\">\r\n        <span class=\"sr-only\">Toggle navigation</span>\r\n        <span class=\"icon-bar\"></span>\r\n        <span class=\"icon-bar\"></span>\r\n        <span class=\"icon-bar\"></span>\r\n      </button>\r\n      <a class=\"navbar-brand\" href=\"#\">PUTOVANJE</a>\r\n    </div>\r\n    <div id=\"navbar\" class=\"navbar-collapse collapse\">\r\n      <ul class=\"nav navbar-nav navbar-right\">\r\n\r\n          <li><a *ngIf=\"!prijavljen\" [routerLink]=\"['/registracija']\"><span class=\"glyphicon glyphicon-user\"></span> Registruj se</a></li>\r\n          <li><a *ngIf=\"!prijavljen\" [routerLink]=\"['/login']\"><span class=\"glyphicon glyphicon-log-in\"></span> Prijavi se</a></li>\r\n          <li><a *ngIf=\"prijavljen\" (click)=\"odjaviSe()\" ><span class=\"glyphicon glyphicon-log-out\"></span> Odjavi se</a></li>\r\n        </ul>\r\n    </div>\r\n  </div>\r\n</nav>\r\n\r\n<nav class=\"navbar\" style=\"margin-bottom: 0px; background-color: aliceblue;\" *ngIf = \"disableNavBar\">\r\n  <ul class=\"nav navbar-nav\">\r\n    <li>\r\n\r\n      <div class=\"dropdown\" dropdown >\r\n        <button class=\"btn\" style=\"background-color: aliceblue; color: black; border-color: aliceblue; margin: 10px; margin-bottom: 0px;\" dropdown-open>Aviokompanije</button>\r\n          <ul class=\"dropdown-menu\">\r\n            <li><a [routerLink]=\"['/aviokompanije']\">Pregled</a></li>          \r\n            <li *ngIf=\"dodavanje()\"><a [routerLink]=\"['/aviokompanije/add']\">Dodavanje</a></li>\r\n          </ul>\r\n    </div>\r\n    </li>\r\n    <li>\r\n\r\n         <div class=\"dropdown\" dropdown>\r\n          <button class=\"btn\" style=\"background-color: aliceblue; color: black; border-color: aliceblue; margin: 10px; margin-bottom: 0px;\" dropdown-open>Hoteli</button>\r\n          <ul class=\"dropdown-menu\">\r\n            <li><a [routerLink]=\"['/hoteli']\">Pregled</a></li>\r\n            <li *ngIf=\"dodavanje()\"><a [routerLink]=\"['/hoteli/add']\">Dodavanje</a></li>\r\n          </ul>\r\n        </div>\r\n\r\n    </li>\r\n    <li>\r\n\r\n        <div class=\"dropdown\" dropdown>\r\n         <button class=\"btn\" style=\"background-color: aliceblue; color: black; border-color: aliceblue; margin: 10px; margin-bottom: 0px;\" dropdown-open>Kompanije Vozila</button>\r\n         <ul class=\"dropdown-menu\">\r\n             <li><a [routerLink]=\"['/kompanije-vozila']\">Pregled</a></li>\r\n             <li *ngIf=\"dodavanje()\"><a [routerLink]=\"['/kompanije-vozila/add']\">Dodavanje</a></li>\r\n           </ul>\r\n         </div>\r\n\r\n     </li>\r\n\r\n     <li *ngIf=\"profilKorisnika()\">\r\n\r\n        <div class=\"dropdown\" dropdown>\r\n          <button class=\"btn\" style=\"background-color: aliceblue; color: black; border-color: aliceblue; margin: 10px; margin-bottom: 0px;\" dropdown-open>Korisnik</button>\r\n          <ul class=\"dropdown-menu\">\r\n              <li><a (click)=\"goToProfile()\">Pregled</a></li>\r\n          </ul>\r\n        </div>\r\n     </li>\r\n\r\n     <li *ngIf=\"profilAdmina()\">\r\n        <div class=\"dropdown\" dropdown>\r\n          <button class=\"btn\" style=\"background-color: aliceblue; color: black; border-color: aliceblue; margin: 10px; margin-bottom: 0px;\" dropdown-open>Korisnik</button>\r\n          <ul class=\"dropdown-menu\">\r\n              <li><a (click)=\"goToProfileAdmin()\">Pregled admin stranice</a></li>\r\n              <li *ngIf = \"vidljivoPopusti()\" ><a [routerLink]=\"['/popusti']\">Podesi popuste</a></li>\r\n          </ul>\r\n        </div>\r\n     </li>\r\n  </ul>\r\n</nav>\r\n\r\n<br>\r\n\r\n\t<router-outlet></router-outlet>"

/***/ }),

/***/ "./src/app/app.component.ts":
/***/ (function(module, exports, __webpack_require__) {

"use strict";

var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
Object.defineProperty(exports, "__esModule", { value: true });
var core_1 = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
var auth_service_1 = __webpack_require__("./src/app/auth.service.ts");
var router_1 = __webpack_require__("./node_modules/@angular/router/esm5/router.js");
var AppComponent = /** @class */ (function () {
    function AppComponent(authService, router) {
        this.authService = authService;
        this.router = router;
        this.disableNavBar = true;
        //public logovaniKorisnik: Korisnik;
        this.prijavljen = false;
        var res = localStorage.getItem('token');
        if (res != null) {
            this.prijavljen = true;
            // let uloga = this.authService.getRoles(res);
            //let email = this.authService.getUsername(res);
            //this.tipkorisnika = this.authService.getRoles(res);
            /*this.korisnikService.findByEmail(email).subscribe(
              s => {
                this.logovaniKorisnik = s;
      
                if ( (uloga === 'ROLE_Administrator_aviokompanije' ||
                uloga === 'ROLE_Administrator_hotela' ||
                uloga === 'ROLE_Administrator_rent_a_car_servisa' ) && !this.logovaniKorisnik.aktiviranNalog){
                  this.disableNavBar = false;
                }
                else{
                  this.disableNavBar = true;
                }
                
              },
              err => console.log("err")
            );*/
        }
    }
    AppComponent.prototype.ngOnInit = function () {
    };
    AppComponent.prototype.goToProfile = function () {
        if (this.tipkorisnika === "ROLE_Registrovani_korisnik") {
            //this.router.navigate(['korisnik/' + this.logovaniKorisnik.id]);
        }
    };
    AppComponent.prototype.podesiPopuste = function () {
        if (this.tipkorisnika === "ROLE_Administrator_sistema") {
            this.router.navigate(['admin/popusti']);
        }
    };
    AppComponent.prototype.odjaviSe = function () {
        this.authService.logout();
        this.prijavljen = false;
        this.router.navigate(['login']);
    };
    AppComponent.prototype.dodavanje = function () {
        // if(this.tipkorisnika === "ROLE_Administrator_sistema"){
        //   return true;
        // }
        // return false; 
        return true;
    };
    AppComponent.prototype.profilKorisnika = function () {
        if (this.tipkorisnika === "ROLE_Registrovani_korisnik") {
            return true;
        }
        return false;
    };
    AppComponent.prototype.profilAdmina = function () {
        if (this.tipkorisnika === "ROLE_Administrator_aviokompanije") {
            return true;
        }
        if (this.tipkorisnika === "ROLE_Administrator_hotela") {
            return true;
        }
        if (this.tipkorisnika === "ROLE_Administrator_rent_a_car_servisa") {
            return true;
        }
        if (this.tipkorisnika === "ROLE_Administrator_sistema") {
            return true;
        }
        return false;
    };
    AppComponent.prototype.vidljivoPopusti = function () {
        if (this.tipkorisnika === "ROLE_Administrator_sistema") {
            return true;
        }
        return false;
    };
    AppComponent.prototype.goToProfileAdmin = function () {
        if (this.tipkorisnika === "ROLE_Administrator_aviokompanije" || this.tipkorisnika === "ROLE_Administrator_hotela" ||
            this.tipkorisnika === "ROLE_Administrator_rent_a_car_servisa" || this.tipkorisnika === "ROLE_Administrator_sistema") {
            //this.router.navigate(['admin/' + this.logovaniKorisnik.id]);
        }
    };
    AppComponent = __decorate([
        core_1.Component({
            selector: 'app-root',
            template: __webpack_require__("./src/app/app.component.html")
        }),
        __metadata("design:paramtypes", [auth_service_1.AuthService, router_1.Router])
    ], AppComponent);
    return AppComponent;
}());
exports.AppComponent = AppComponent;


/***/ }),

/***/ "./src/app/app.module.ts":
/***/ (function(module, exports, __webpack_require__) {

"use strict";

var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
Object.defineProperty(exports, "__esModule", { value: true });
var platform_browser_1 = __webpack_require__("./node_modules/@angular/platform-browser/esm5/platform-browser.js");
var animations_1 = __webpack_require__("./node_modules/@angular/platform-browser/esm5/animations.js");
var core_1 = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
var forms_1 = __webpack_require__("./node_modules/@angular/forms/esm5/forms.js");
var http_1 = __webpack_require__("./node_modules/@angular/http/esm5/http.js");
var http_2 = __webpack_require__("./node_modules/@angular/common/esm5/http.js");
var router_1 = __webpack_require__("./node_modules/@angular/router/esm5/router.js");
var ngx_pagination_1 = __webpack_require__("./node_modules/ngx-pagination/dist/ngx-pagination.js");
var app_component_1 = __webpack_require__("./src/app/app.component.ts");
var ngx_rating_1 = __webpack_require__("./node_modules/ngx-rating/index.js");
var ng_pick_datetime_1 = __webpack_require__("./node_modules/ng-pick-datetime/picker.js");
var h_interceptor_service_1 = __webpack_require__("./src/app/h-interceptor.service.ts");
var http_3 = __webpack_require__("./node_modules/@angular/common/esm5/http.js");
var ngx_dropdown_1 = __webpack_require__("./node_modules/ngx-dropdown/index.js");
var ngx_tabs_1 = __webpack_require__("./node_modules/ngx-tabs/index.js");
var ng_multiselect_dropdown_1 = __webpack_require__("./node_modules/ng-multiselect-dropdown/fesm5/ng-multiselect-dropdown.js");
var auth_service_1 = __webpack_require__("./src/app/auth.service.ts");
var ng5_slider_1 = __webpack_require__("./node_modules/ng5-slider/esm5/ng5-slider.js");
var page_not_found_component_1 = __webpack_require__("./src/app/component/obavestenja/page-not-found/page-not-found.component.ts");
var prikaz_vozila_component_1 = __webpack_require__("./src/app/component/vozila/prikaz-vozila/prikaz-vozila.component.ts");
var prikaz_kompanija_vozila_component_1 = __webpack_require__("./src/app/component/vozila/prikaz-kompanija-vozila/prikaz-kompanija-vozila.component.ts");
var azuriranje_vozila_component_1 = __webpack_require__("./src/app/component/vozila/azuriranje-vozila/azuriranje-vozila.component.ts");
var azuriranje_kompanije_vozila_component_1 = __webpack_require__("./src/app/component/vozila/azuriranje-kompanije-vozila/azuriranje-kompanije-vozila.component.ts");
var vozilo_service_1 = __webpack_require__("./src/app/service/vozila/vozilo.service.ts");
var kompanija_vozila_service_1 = __webpack_require__("./src/app/service/vozila/kompanija-vozila.service.ts");
var prikaz_garaza_component_1 = __webpack_require__("./src/app/component/vozila/prikaz-garaza/prikaz-garaza.component.ts");
var garaza_service_1 = __webpack_require__("./src/app/service/vozila/garaza.service.ts");
var azuriranje_garaze_component_1 = __webpack_require__("./src/app/component/vozila/azuriranje-garaze/azuriranje-garaze.component.ts");
var prikaz_hotela_component_1 = __webpack_require__("./src/app/component/hotel/prikaz-hotela/prikaz-hotela.component.ts");
var azuriranje_hotela_component_1 = __webpack_require__("./src/app/component/hotel/azuriranje-hotela/azuriranje-hotela.component.ts");
var azuriranje_opcija_component_1 = __webpack_require__("./src/app/component/hotel/azuriranje-opcija/azuriranje-opcija.component.ts");
var prikaz_opcija_component_1 = __webpack_require__("./src/app/component/hotel/prikaz-opcija/prikaz-opcija.component.ts");
var prikaz_soba_component_1 = __webpack_require__("./src/app/component/hotel/prikaz-soba/prikaz-soba.component.ts");
var azuriranje_soba_component_1 = __webpack_require__("./src/app/component/hotel/azuriranje-soba/azuriranje-soba.component.ts");
var hotel_service_1 = __webpack_require__("./src/app/service/hotel/hotel.service.ts");
var soba_service_1 = __webpack_require__("./src/app/service/hotel/soba.service.ts");
var opcija_service_1 = __webpack_require__("./src/app/service/hotel/opcija.service.ts");
var prikaz_cenovnika_component_1 = __webpack_require__("./src/app/component/hotel/prikaz-cenovnika/prikaz-cenovnika.component.ts");
var azuriranje_cenovnika_component_1 = __webpack_require__("./src/app/component/hotel/azuriranje-cenovnika/azuriranje-cenovnika.component.ts");
var cenovnik_service_1 = __webpack_require__("./src/app/service/hotel/cenovnik.service.ts");
var appRoutes = [
    /*{ path: 'record/:id', component: RecordDetailsComponent },
    { path: 'main', component: MainComponent },
    { path: '', redirectTo: 'main', pathMatch: 'full' },*/
    // ----------------------------------------rent a car
    { path: 'kompanije-vozila', component: prikaz_kompanija_vozila_component_1.PrikazKompanijaVozilaComponent },
    { path: 'kompanije-vozila/add', component: azuriranje_kompanije_vozila_component_1.AzuriranjeKompanijeVozilaComponent },
    { path: 'kompanije-vozila/add/:id', component: azuriranje_kompanije_vozila_component_1.AzuriranjeKompanijeVozilaComponent },
    { path: 'kompanije-vozila/:kompanija-id/garaze', component: prikaz_garaza_component_1.PrikazGarazaComponent },
    { path: 'kompanije-vozila/:kompanija-id/garaze/add', component: azuriranje_garaze_component_1.AzuriranjeGarazeComponent },
    { path: 'kompanije-vozila/:kompanija-id/garaze/add/:garaza-id', component: azuriranje_garaze_component_1.AzuriranjeGarazeComponent },
    { path: 'kompanije-vozila/:kompanija-id/garaze/:garaza-id/vozila', component: prikaz_vozila_component_1.PrikazVozilaComponent },
    { path: 'kompanije-vozila/:kompanija-id/garaze/:garaza-id/vozila/add', component: azuriranje_vozila_component_1.AzuriranjeVozilaComponent },
    { path: 'kompanije-vozila/:kompanija-id/garaze/:garaza-id/vozila/add/:id', component: azuriranje_vozila_component_1.AzuriranjeVozilaComponent },
    // --------------------------------------------- hotel
    { path: 'hoteli', component: prikaz_hotela_component_1.PrikazHotelaComponent },
    { path: 'hoteli/add', component: azuriranje_hotela_component_1.AzuriranjeHotelaComponent },
    { path: 'hoteli/add/:id', component: azuriranje_hotela_component_1.AzuriranjeHotelaComponent },
    { path: 'hoteli/:hotel-id/opcije', component: prikaz_opcija_component_1.PrikazOpcijaComponent },
    { path: 'hoteli/:hotel-id/opcije/add', component: azuriranje_opcija_component_1.AzuriranjeOpcijaComponent },
    { path: 'hoteli/:hotel-id/opcije/add/:opcija-id', component: azuriranje_opcija_component_1.AzuriranjeOpcijaComponent },
    { path: 'hoteli/:hotel-id/sobe', component: prikaz_soba_component_1.PrikazSobaComponent },
    { path: 'hoteli/:hotel-id/sobe/add', component: azuriranje_soba_component_1.AzuriranjeSobaComponent },
    { path: 'hoteli/:hotel-id/sobe/add/:soba-id', component: azuriranje_soba_component_1.AzuriranjeSobaComponent },
    { path: 'hoteli/:hotel-id/sobe/:soba-id/cenovnici', component: prikaz_cenovnika_component_1.PrikazCenovnikaComponent },
    { path: 'hoteli/:hotel-id/sobe/:soba-id/cenovnici/add', component: azuriranje_cenovnika_component_1.AzuriranjeCenovnikaComponent },
    { path: 'hoteli/:hotel-id/sobe/:soba-id/cenovnici/add/:id', component: azuriranje_cenovnika_component_1.AzuriranjeCenovnikaComponent },
    { path: 'putanja', component: page_not_found_component_1.PageNotFoundComponent },
    { path: '**', component: page_not_found_component_1.PageNotFoundComponent }
];
var AppModule = /** @class */ (function () {
    function AppModule() {
    }
    AppModule = __decorate([
        core_1.NgModule({
            declarations: [
                app_component_1.AppComponent,
                page_not_found_component_1.PageNotFoundComponent,
                prikaz_vozila_component_1.PrikazVozilaComponent,
                prikaz_kompanija_vozila_component_1.PrikazKompanijaVozilaComponent,
                azuriranje_vozila_component_1.AzuriranjeVozilaComponent,
                azuriranje_kompanije_vozila_component_1.AzuriranjeKompanijeVozilaComponent,
                prikaz_garaza_component_1.PrikazGarazaComponent,
                azuriranje_garaze_component_1.AzuriranjeGarazeComponent,
                prikaz_hotela_component_1.PrikazHotelaComponent,
                azuriranje_hotela_component_1.AzuriranjeHotelaComponent,
                azuriranje_opcija_component_1.AzuriranjeOpcijaComponent,
                prikaz_opcija_component_1.PrikazOpcijaComponent,
                prikaz_soba_component_1.PrikazSobaComponent,
                azuriranje_soba_component_1.AzuriranjeSobaComponent,
                prikaz_cenovnika_component_1.PrikazCenovnikaComponent,
                azuriranje_cenovnika_component_1.AzuriranjeCenovnikaComponent,
            ],
            imports: [
                platform_browser_1.BrowserModule,
                animations_1.BrowserAnimationsModule,
                forms_1.FormsModule,
                http_1.HttpModule,
                http_2.HttpClientModule,
                ngx_pagination_1.NgxPaginationModule,
                ngx_rating_1.RatingModule,
                ngx_dropdown_1.DropdownModule,
                ngx_tabs_1.TabsModule,
                ng_pick_datetime_1.OwlDateTimeModule,
                ng_pick_datetime_1.OwlNativeDateTimeModule,
                ng_multiselect_dropdown_1.NgMultiSelectDropDownModule.forRoot(),
                ng5_slider_1.Ng5SliderModule,
                router_1.RouterModule.forRoot(appRoutes, { enableTracing: false, useHash: true } // <-- debugging purposes only
                )
            ],
            providers: [
                auth_service_1.AuthService,
                vozilo_service_1.VoziloService,
                kompanija_vozila_service_1.KompanijaVozilaService,
                garaza_service_1.GarazaService,
                hotel_service_1.HotelService,
                soba_service_1.SobaService,
                opcija_service_1.OpcijaService,
                cenovnik_service_1.CenovnikService,
                {
                    provide: http_3.HTTP_INTERCEPTORS,
                    useClass: h_interceptor_service_1.HInterceptorService,
                    multi: true
                },
            ],
            bootstrap: [app_component_1.AppComponent]
        })
    ], AppModule);
    return AppModule;
}());
exports.AppModule = AppModule;


/***/ }),

/***/ "./src/app/auth.service.ts":
/***/ (function(module, exports, __webpack_require__) {

"use strict";

var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
Object.defineProperty(exports, "__esModule", { value: true });
var core_1 = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
var http_1 = __webpack_require__("./node_modules/@angular/common/esm5/http.js");
var router_1 = __webpack_require__("./node_modules/@angular/router/esm5/router.js");
//import { KorisnikRegistracija } from './model/korisnik/korisnikRegistracija';
var AuthService = /** @class */ (function () {
    function AuthService(http, router) {
        this.http = http;
        this.router = router;
    }
    /*getRoles(token: string) {
      let jwtData = token.split('.')[1];
      let decodedJwtJsonData = window.atob(jwtData);
      let decodedJwtData = JSON.parse(decodedJwtJsonData);
      console.log(decodedJwtData);
      console.log(decodedJwtData.auth[0].authority);
      console.log(decodedJwtData.sub); //username
      return decodedJwtData.auth[0].authority; //you can access role or username
    }
  
    getUsername(token: string) : string{
      let jwtData = token.split('.')[1];
      let decodedJwtJsonData = window.atob(jwtData);
      let decodedJwtData = JSON.parse(decodedJwtJsonData);
      console.log(decodedJwtData);
      console.log(decodedJwtData.auth[0].authority);
      console.log(decodedJwtData.sub); //username
      return decodedJwtData.sub; //you can access role or username
    }
  
    login(email:string, lozinka:string): Observable<string>{
      const headers = new HttpHeaders().set('Content-Type', 'text/plain; charset=utf-8');
      return this.http
        .post<string>('/api/login', {email, lozinka});
    }*/
    /*signup(korisnik: KorisnikRegistracija): Observable<string>{
      return this.http
        .post<string>('/api/signup', korisnik);
    }

    registerAdmin(id: number,korisnik: KorisnikRegistracija): Observable<string>{
      return this.http
        .post<string>(`/api/register/${id}`, korisnik);
    }*/
    AuthService.prototype.logout = function () {
        localStorage.removeItem('token');
        this.router.navigate(['login']);
    };
    AuthService = __decorate([
        core_1.Injectable(),
        __metadata("design:paramtypes", [http_1.HttpClient,
            router_1.Router])
    ], AuthService);
    return AuthService;
}());
exports.AuthService = AuthService;


/***/ }),

/***/ "./src/app/component/hotel/azuriranje-cenovnika/azuriranje-cenovnika.component.css":
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/component/hotel/azuriranje-cenovnika/azuriranje-cenovnika.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"container\" style=\"display: flex; justify-content: center;\">\n    <div class=\"col-md-5 form\">\n        <div class=\"form-area\">  \n            <form role=\"form\" #formFilijala=\"ngForm\">\n            <br style=\"clear:both\">\n                        <h3 style=\"margin-bottom: 25px; text-align: center;\">Azuriranje/Dodavanje cenovnika</h3>\n                <div class=\"form-group\">\n                <label>Pocetni datum </label>\n                <input class=\"form-control mr-sm-2\" placeholder=\"Pocetni datum:\" \n                [(ngModel)]=\"cenovnik.pocetniDatum\"\n                [min]=\"min\"\n                (change)=\"promenaDatuma()\"\n                [owlDateTimeTrigger]=\"dt1\" [owlDateTime]=\"dt1\"  [ngModelOptions]=\"{standalone: true}\">\n        <owl-date-time [pickerType]=\"'calendar'\" #dt1></owl-date-time>\n              </div>\n              <div class=\"form-group\">\n                  <label>Krajnji datum </label>\n                  <input class=\"form-control mr-sm-2\" placeholder=\"Krajnji datum:\" \n                  [(ngModel)]=\"cenovnik.krajnjiDatum\"\n                  [min]=\"min\"\n                  (change)=\"promenaDatuma()\"\n                  [owlDateTimeTrigger]=\"dt2\" [owlDateTime]=\"dt2\"  [ngModelOptions]=\"{standalone: true}\">\n          <owl-date-time [pickerType]=\"'calendar'\" #dt2></owl-date-time>\n                </div>\n              <div class=\"form-group\">\n                    <label>Cena</label>\n                  <input type=\"text\" class=\"form-control\" id=\"cena\" name=\"cena\" minlength=\"1\" #zemlja=\"ngModel\" placeholder=\"cena\" required [(ngModel)] = \"cenovnik.cena\">\n                  <small [hidden]=\"zemlja.valid || (zemlja.pristine && !formFilijala.submitted)\" class=\"text-danger\">\n                    Cena je obavezna (veca od nule).\n                  </small>\n                 </div>\n              <button *ngIf=\"isDataAvailable\" type=\"button\" [disabled]=\"!formFilijala.valid\" id=\"submit\" name=\"submit\" class=\"btn btn-primary pull-right\" (click) = \"update()\">Azuriraj</button>\n              <button *ngIf=\"!isDataAvailable\" type=\"button\" [disabled]=\"!formFilijala.valid\" id=\"submit\" name=\"submit\" class=\"btn btn-primary pull-right\" (click) = \"save()\">Kreiraj</button>\n              \n              <button type=\"button\" id=\"submit\" name=\"submit\" class=\"btn btn-primary pull-right\" (click) = \"goBack()\">Odustani</button>\n            </form>\n        </div>\n    </div>\n    </div>"

/***/ }),

/***/ "./src/app/component/hotel/azuriranje-cenovnika/azuriranje-cenovnika.component.ts":
/***/ (function(module, exports, __webpack_require__) {

"use strict";

var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
Object.defineProperty(exports, "__esModule", { value: true });
var core_1 = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
var cenovnikSobe_1 = __webpack_require__("./src/app/model/hotel/cenovnikSobe.ts");
var router_1 = __webpack_require__("./node_modules/@angular/router/esm5/router.js");
var cenovnik_service_1 = __webpack_require__("./src/app/service/hotel/cenovnik.service.ts");
var AzuriranjeCenovnikaComponent = /** @class */ (function () {
    function AzuriranjeCenovnikaComponent(cenovnikService, route, router) {
        this.cenovnikService = cenovnikService;
        this.route = route;
        this.router = router;
        this.cenovnik = new cenovnikSobe_1.CenovnikSobe();
        this.maksimalnaDuzina = 30;
    }
    AzuriranjeCenovnikaComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.sub = this.route.params.subscribe(function (params) {
            _this.isDataAvailable = false;
            _this.kompanijaId = +params['hotel-id'];
            _this.sobaId = +params['soba-id'];
            if (params['id'] != null) {
                _this.id = +params['id']; // (+) konvertuje string 'id' u broj
                //id postavljamo kao path parametar pomocu interpolacije stringa
                if (_this.id != null) {
                    _this.cenovnikService.findOne(_this.kompanijaId, _this.sobaId, _this.id).subscribe(function (e) {
                        _this.cenovnik = e;
                    });
                    _this.isDataAvailable = true;
                }
                else {
                    _this.isDataAvailable = false;
                    _this.cenovnik = new cenovnikSobe_1.CenovnikSobe();
                }
            }
            //  else{
            //   this.isDataAvailable = false;
            //   this.opcija = new Opcija();
            //   this.kompanijaService.findOne(this.kompanijaId).subscribe(
            //     succ => {
            //       this.opcija.kompanijaDTO = succ;
            //     }
            //   );
            // }
        });
    };
    AzuriranjeCenovnikaComponent.prototype.save = function () {
        var _this = this;
        var message = this.proveriUnos();
        if (message === "OK") {
            this.cenovnik.pocetniDatum = this.konvertujUDobroVreme(this.cenovnik.pocetniDatum.toString().substring(4, 15));
            this.cenovnik.krajnjiDatum = this.konvertujUDobroVreme(this.cenovnik.krajnjiDatum.toString().substring(4, 15));
            this.cenovnikService.add(this.cenovnik, this.kompanijaId, this.sobaId).subscribe(function (s) {
                _this.cenovnik = s;
                _this.router.navigate(['hoteli/' + _this.kompanijaId + '/sobe/' + _this.sobaId + '/cenovnici']);
            }, function (err) { return console.log("err"); });
        }
        else {
            alert(message);
        }
    };
    AzuriranjeCenovnikaComponent.prototype.update = function () {
        var _this = this;
        var message = this.proveriUnos();
        if (message === "OK") {
            this.cenovnik.pocetniDatum = this.konvertujUDobroVreme(this.cenovnik.pocetniDatum.toString().substring(4, 15));
            this.cenovnik.krajnjiDatum = this.konvertujUDobroVreme(this.cenovnik.krajnjiDatum.toString().substring(4, 15));
            this.cenovnikService.update(this.kompanijaId, this.sobaId, this.cenovnik).subscribe(function (s) {
                _this.cenovnik = s;
                _this.router.navigate(['hoteli/' + _this.kompanijaId + '/sobe/' + _this.sobaId + '/cenovnici']);
            }, function (err) { return console.log("err"); });
        }
        else {
            alert(message);
        }
    };
    AzuriranjeCenovnikaComponent.prototype.goBack = function () {
        this.router.navigate(['hoteli/' + this.kompanijaId + '/sobe/' + this.sobaId + '/cenovnici']);
    };
    AzuriranjeCenovnikaComponent.prototype.proveriUnos = function () {
        if (this.cenovnik.cena < 0) {
            return "Morate popuniti cenu koja mora biti pozitivan broj";
        }
        return "OK";
    };
    AzuriranjeCenovnikaComponent.prototype.konvertujUDobroVreme = function (primljeniString) {
        var pravoVreme;
        pravoVreme = primljeniString.substring(7, 11) + "-" + primljeniString.substring(0, 3) + "-" + primljeniString.substring(4, 6);
        pravoVreme = this.mesecPrebaciUbroj(pravoVreme);
        //alert(pravoVreme)
        return pravoVreme;
    };
    AzuriranjeCenovnikaComponent.prototype.mesecPrebaciUbroj = function (primljeniString) {
        primljeniString = primljeniString.replace("Jan", "01");
        primljeniString = primljeniString.replace("Feb", "02");
        primljeniString = primljeniString.replace("Mar", "03");
        primljeniString = primljeniString.replace("Apr", "04");
        primljeniString = primljeniString.replace("May", "05");
        primljeniString = primljeniString.replace("Jun", "06");
        primljeniString = primljeniString.replace("Jul", "07");
        primljeniString = primljeniString.replace("Aug", "08");
        primljeniString = primljeniString.replace("Sep", "09");
        primljeniString = primljeniString.replace("Oct", "10");
        primljeniString = primljeniString.replace("Nov", "11");
        primljeniString = primljeniString.replace("Dec", "12");
        return primljeniString;
    };
    AzuriranjeCenovnikaComponent = __decorate([
        core_1.Component({
            selector: 'app-azuriranje-cenovnika',
            template: __webpack_require__("./src/app/component/hotel/azuriranje-cenovnika/azuriranje-cenovnika.component.html"),
            styles: [__webpack_require__("./src/app/component/hotel/azuriranje-cenovnika/azuriranje-cenovnika.component.css")]
        }),
        __metadata("design:paramtypes", [cenovnik_service_1.CenovnikService, router_1.ActivatedRoute, router_1.Router])
    ], AzuriranjeCenovnikaComponent);
    return AzuriranjeCenovnikaComponent;
}());
exports.AzuriranjeCenovnikaComponent = AzuriranjeCenovnikaComponent;


/***/ }),

/***/ "./src/app/component/hotel/azuriranje-hotela/azuriranje-hotela.component.css":
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/component/hotel/azuriranje-hotela/azuriranje-hotela.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"container\" style=\"display: flex; justify-content: center;\">\n    <div class=\"col-md-5 form\">\n        <div class=\"form-area\">  \n            <form role=\"form\" #formRent=\"ngForm\">\n            <br style=\"clear:both\">\n                        <h3 style=\"margin-bottom: 25px; text-align: center;\">Azuriranje Hotela</h3>\n              <div class=\"form-group\">\n                  <input type=\"text\" class=\"form-control\" id=\"naziv\" minlength=\"3\" maxlength=\"30\" #naziv=\"ngModel\" name=\"naziv\" placeholder=\"Naziv\" required [(ngModel)] = \"hotel.naziv\">\n                  <small [hidden]=\"naziv.valid || (naziv.pristine && !formRent.submitted)\" class=\"text-danger\">\n                    Naziv je obavezan(minimum 3 karaktera a maksimum 30 karaktera).\n                  </small>\n              </div>\n               <div class=\"form-group\">\n                  <label>Zemlja</label>\n                <input type=\"text\" class=\"form-control\" id=\"zemlja\" name=\"zemlja\" minlength=\"3\" maxlength=\"30\" #zemlja=\"ngModel\" placeholder=\"zemlja\" required [(ngModel)] = \"hotel.adresaDTO.zemlja\">\n                <small [hidden]=\"zemlja.valid || (zemlja.pristine && !formRent.submitted)\" class=\"text-danger\">\n                  Zemlja je obavezna (minimum 3 karaktera a maksimum 30 karaktera).\n                </small>\n              </div>\n              <div class=\"form-group\">\n                  <label>Grad</label>\n                <input type=\"text\" class=\"form-control\" id=\"grad\" name=\"grad\" minlength=\"3\" maxlength=\"30\" #grad=\"ngModel\" placeholder=\"grad\" required [(ngModel)] = \"hotel.adresaDTO.grad\">\n                <small [hidden]=\"grad.valid || (grad.pristine && !formRent.submitted)\" class=\"text-danger\">\n                  Grad je obavezan (minimum 3 karaktera a maksimum 30 karaktera).\n                </small>\n              </div>\n              <div class=\"form-group\">\n                  <label>Ulica</label>\n                <input type=\"text\" class=\"form-control\" id=\"ulica\" name=\"ulica\" minlength=\"3\" maxlength=\"30\" #ulica=\"ngModel\" placeholder=\"ulica\" required [(ngModel)] = \"hotel.adresaDTO.ulica\">\n                <small [hidden]=\"ulica.valid || (ulica.pristine && !formRent.submitted)\" class=\"text-danger\">\n                  Ulica je obavezna (minimum 3 karaktera a maksimum 30 karaktera).\n                </small>\n              </div>\n              <div class=\"form-group\">\n                  <label>Broj</label>\n                <input type=\"text\" class=\"form-control\" id=\"broj\" name=\"broj\" minlength=\"1\"  #broj=\"ngModel\" placeholder=\"broj\" required [(ngModel)] = \"hotel.adresaDTO.broj\">\n                <small [hidden]=\"broj.valid || (broj.pristine && !formRent.submitted)\" class=\"text-danger\">\n                  Broj je obavezan (Veci od 0).\n                </small> \n              </div>\n              <div class=\"form-group\">\n                <label>Geografska duzina</label>\n              <input type=\"text\" class=\"form-control\" minlength=\"1\" maxlength=\"30\" id=\"duzina\" name=\"duzina\" #duzina = \"ngModel\" placeholder=\"Geografska duzina\" required [(ngModel)] = \"hotel.longitude\">\n              <small [hidden]=\"duzina.valid || (duzina.pristine && !formRent.submitted)\" class=\"text-danger\">\n                Geografska duzina je obavezna (minimum 1 karaktera a maksimum 30 karaktera).\n              </small>\n              </div>\n              <div class=\"form-group\">\n                  <label>Geografska sirina</label>\n                <input type=\"text\" class=\"form-control\" maxlength=\"30\" id=\"sirina\" name=\"sirina\" #sirina = \"ngModel\" placeholder=\"Geografska sirina\" required [(ngModel)] = \"hotel.latitude\">\n                <small [hidden]=\"sirina.valid || (sirina.pristine && !formRent.submitted)\" class=\"text-danger\">\n                  Geografska sirina je obavezna (minimum 1 karaktera a maksimum 30 karaktera).\n                </small>\n              </div>\n              <div class=\"form-group\">\n                <textarea [(ngModel)] = \"hotel.opis\" maxlength=\"140\" #opis=\"ngModel\" [ngModelOptions]=\"{standalone: true}\" class=\"form-control\" type=\"textarea\" id=\"promotivniOpis\" placeholder=\"Promotivni opis\" maxlength=\"140\" rows=\"7\" style=\"max-width: 100%; min-width: 100%;\" ></textarea>\n                <span class=\"help-block\"><p id=\"characterLeft\" class=\"help-block \">Maksimum 140 karaktera</p></span>                    \n                <small [hidden]=\"opis.valid || (opis.pristine && !formRent.submitted)\" class=\"text-danger\">\n                  Promotivni opis je obavezan (minimum 3 karaktera a maksimum 140 karaktera).\n                </small>\n              </div>\n                \n            <button *ngIf=\"isDataAvailable\" type=\"button\" [disabled]=\"!formRent.valid\" id=\"submit\" style=\"margin:5px;\" name=\"submit\" class=\"btn btn-primary pull-right\" (click) = \"update()\">Azuriraj</button>\n            <button *ngIf=\"!isDataAvailable\" type=\"button\" [disabled]=\"!formRent.valid\" id=\"submit\" style=\"margin:5px;\" name=\"submit\" class=\"btn btn-primary pull-right\" (click) = \"save()\">Kreiraj</button>\n            <button type=\"button\" id=\"submit\" name=\"submit\" style=\"margin:5px;\" class=\"btn btn-primary pull-right\" (click) = \"goBack()\">Odustani</button>\n            </form>\n        </div>\n    </div>\n    </div>"

/***/ }),

/***/ "./src/app/component/hotel/azuriranje-hotela/azuriranje-hotela.component.ts":
/***/ (function(module, exports, __webpack_require__) {

"use strict";

var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
Object.defineProperty(exports, "__esModule", { value: true });
var core_1 = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
var hotel_1 = __webpack_require__("./src/app/model/hotel/hotel.ts");
var hotel_service_1 = __webpack_require__("./src/app/service/hotel/hotel.service.ts");
var router_1 = __webpack_require__("./node_modules/@angular/router/esm5/router.js");
var AzuriranjeHotelaComponent = /** @class */ (function () {
    function AzuriranjeHotelaComponent(hotelService, route, router) {
        this.hotelService = hotelService;
        this.route = route;
        this.router = router;
        this.hotel = new hotel_1.Hotel();
        this.maksimalnaDuzina = 30;
        this.maksimalnaDuzinaOpis = 140;
    }
    AzuriranjeHotelaComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.sub = this.route.params.subscribe(function (params) {
            _this.isDataAvailable = false;
            if (params['id'] != null) {
                _this.id = +params['id']; // (+) konvertuje string 'id' u broj
                //id postavljamo kao path parametar pomocu interpolacije stringa
                if (_this.id != null) {
                    _this.hotelService.findOne(_this.id).subscribe(function (e) {
                        _this.hotel = e;
                    });
                    _this.isDataAvailable = true;
                }
                else {
                    //znaci dodajem novi koji ne postoji
                    _this.hotel = new hotel_1.Hotel();
                    _this.isDataAvailable = false;
                }
            }
        });
    };
    AzuriranjeHotelaComponent.prototype.save = function () {
        var _this = this;
        var message = this.proveriUnosRentacar();
        if (message === "OK") {
            this.hotelService.add(this.hotel).subscribe(function (s) {
                _this.hotel = s;
                _this.router.navigate(['hoteli']);
            }, function (err) { return console.log("err"); });
        }
        else {
            alert(message);
        }
    };
    AzuriranjeHotelaComponent.prototype.update = function () {
        var _this = this;
        var message = this.proveriUnosRentacar();
        if (message === "OK") {
            this.hotelService.update(this.hotel.id, this.hotel).subscribe(function (s) {
                _this.hotel = s;
                _this.router.navigate(['hoteli']);
            }, function (err) { return console.log("err"); });
        }
        else {
            alert(message);
        }
    };
    AzuriranjeHotelaComponent.prototype.goBack = function () {
        this.router.navigate(['hoteli']);
    };
    AzuriranjeHotelaComponent.prototype.proveriUnosRentacar = function () {
        if (this.hotel.naziv === "" || this.hotel.naziv.length > this.maksimalnaDuzina) {
            return "Morate popuniti naziv rent-a koja mora biti kraci od " + this.maksimalnaDuzina + " karaktera";
        }
        /*if(this.hotel.adresa === "" ||this.hotel.adresa.length > this.maksimalnaDuzina){
          return "Morate popuniti adresu rent-a koja mora biti kraca od " + this.maksimalnaDuzina + " karaktera";
        }*/
        if (this.hotel.opis === "" || this.hotel.opis.length > this.maksimalnaDuzinaOpis) {
            return "Morate popuniti opis rent-a koji mora biti kraca od " + this.maksimalnaDuzinaOpis + " karaktera";
        }
        /*if(isNaN(this.hotel.latitude) || isNaN(this.hotel.longitude)){
          return "Geografska sirina i duzina moraju biti brojevi";
        }*/
        return "OK";
    };
    AzuriranjeHotelaComponent = __decorate([
        core_1.Component({
            selector: 'app-azuriranje-hotela',
            template: __webpack_require__("./src/app/component/hotel/azuriranje-hotela/azuriranje-hotela.component.html"),
            styles: [__webpack_require__("./src/app/component/hotel/azuriranje-hotela/azuriranje-hotela.component.css")]
        }),
        __metadata("design:paramtypes", [hotel_service_1.HotelService, router_1.ActivatedRoute, router_1.Router])
    ], AzuriranjeHotelaComponent);
    return AzuriranjeHotelaComponent;
}());
exports.AzuriranjeHotelaComponent = AzuriranjeHotelaComponent;


/***/ }),

/***/ "./src/app/component/hotel/azuriranje-opcija/azuriranje-opcija.component.css":
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/component/hotel/azuriranje-opcija/azuriranje-opcija.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"container\" style=\"display: flex; justify-content: center;\">\n    <div class=\"col-md-5 form\">\n        <div class=\"form-area\">  \n            <form role=\"form\" #formFilijala=\"ngForm\">\n            <br style=\"clear:both\">\n                        <h3 style=\"margin-bottom: 25px; text-align: center;\">Azuriranje/Dodavanje Opcije</h3>\n                <div class=\"form-group\">\n                <label>Ime </label>\n                <input type=\"text\"  class=\"form-control\" minlength=\"3\" maxlength=\"30\" #ime=\"ngModel\" id=\"ime\" name=\"ime\" placeholder=\"Ime\" required [(ngModel)] = \"opcija.naziv\">\n                <small [hidden]=\"ime.valid || (ime.pristine && !formFilijala.submitted)\" class=\"text-danger\">\n                    Ime je obavezno (minimum 3 karaktera a maksimum 30 karaktera).\n                </small>\n              </div>\n              <div class=\"form-group\">\n                    <label>Cena</label>\n                  <input type=\"text\" class=\"form-control\" id=\"cena\" name=\"cena\" minlength=\"1\" #zemlja=\"ngModel\" placeholder=\"cena\" required [(ngModel)] = \"opcija.cena\">\n                  <small [hidden]=\"zemlja.valid || (zemlja.pristine && !formFilijala.submitted)\" class=\"text-danger\">\n                    Cena je obavezna (veca od nule).\n                  </small>\n                 </div>\n              <button *ngIf=\"isDataAvailable\" type=\"button\" [disabled]=\"!formFilijala.valid\" id=\"submit\" name=\"submit\" class=\"btn btn-primary pull-right\" (click) = \"update()\">Azuriraj</button>\n              <button *ngIf=\"!isDataAvailable\" type=\"button\" [disabled]=\"!formFilijala.valid\" id=\"submit\" name=\"submit\" class=\"btn btn-primary pull-right\" (click) = \"save()\">Kreiraj</button>\n              \n              <button type=\"button\" id=\"submit\" name=\"submit\" class=\"btn btn-primary pull-right\" (click) = \"goBack()\">Odustani</button>\n            </form>\n        </div>\n    </div>\n    </div>"

/***/ }),

/***/ "./src/app/component/hotel/azuriranje-opcija/azuriranje-opcija.component.ts":
/***/ (function(module, exports, __webpack_require__) {

"use strict";

var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
Object.defineProperty(exports, "__esModule", { value: true });
var core_1 = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
var opcija_1 = __webpack_require__("./src/app/model/hotel/opcija.ts");
var opcija_service_1 = __webpack_require__("./src/app/service/hotel/opcija.service.ts");
var router_1 = __webpack_require__("./node_modules/@angular/router/esm5/router.js");
var AzuriranjeOpcijaComponent = /** @class */ (function () {
    function AzuriranjeOpcijaComponent(opcijaService, route, router) {
        this.opcijaService = opcijaService;
        this.route = route;
        this.router = router;
        this.opcija = new opcija_1.Opcija();
        this.maksimalnaDuzina = 30;
    }
    AzuriranjeOpcijaComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.sub = this.route.params.subscribe(function (params) {
            _this.isDataAvailable = false;
            _this.kompanijaId = +params['hotel-id'];
            if (params['opcija-id'] != null) {
                _this.id = +params['opcija-id']; // (+) konvertuje string 'id' u broj
                //id postavljamo kao path parametar pomocu interpolacije stringa
                if (_this.id != null) {
                    _this.opcijaService.findOne(_this.kompanijaId, _this.id).subscribe(function (e) {
                        _this.opcija = e;
                    });
                    _this.isDataAvailable = true;
                }
                else {
                    _this.isDataAvailable = false;
                    _this.opcija = new opcija_1.Opcija();
                }
            }
            //  else{
            //   this.isDataAvailable = false;
            //   this.opcija = new Opcija();
            //   this.kompanijaService.findOne(this.kompanijaId).subscribe(
            //     succ => {
            //       this.opcija.kompanijaDTO = succ;
            //     }
            //   );
            // }
        });
    };
    AzuriranjeOpcijaComponent.prototype.save = function () {
        var _this = this;
        var message = this.proveriUnos();
        if (message === "OK") {
            this.opcijaService.add(this.opcija, this.kompanijaId).subscribe(function (s) {
                _this.opcija = s;
                _this.router.navigate(['hoteli/' + _this.kompanijaId + '/opcije']);
            }, function (err) { return console.log("err"); });
        }
        else {
            alert(message);
        }
    };
    AzuriranjeOpcijaComponent.prototype.update = function () {
        var _this = this;
        var message = this.proveriUnos();
        if (message === "OK") {
            this.opcijaService.update(this.kompanijaId, this.opcija).subscribe(function (s) {
                _this.opcija = s;
                _this.router.navigate(['hoteli/' + _this.kompanijaId + '/opcije']);
            }, function (err) { return console.log("err"); });
        }
        else {
            alert(message);
        }
    };
    AzuriranjeOpcijaComponent.prototype.goBack = function () {
        this.router.navigate(['hoteli/' + this.kompanijaId + '/opcije']);
    };
    AzuriranjeOpcijaComponent.prototype.proveriUnos = function () {
        if (this.opcija.naziv === "" || this.opcija.naziv.length > this.maksimalnaDuzina) {
            return "Morate popuniti ime filijale koje mora biti kraca od " + this.maksimalnaDuzina + " karaktera";
        }
        return "OK";
    };
    AzuriranjeOpcijaComponent = __decorate([
        core_1.Component({
            selector: 'app-azuriranje-opcija',
            template: __webpack_require__("./src/app/component/hotel/azuriranje-opcija/azuriranje-opcija.component.html"),
            styles: [__webpack_require__("./src/app/component/hotel/azuriranje-opcija/azuriranje-opcija.component.css")]
        }),
        __metadata("design:paramtypes", [opcija_service_1.OpcijaService, router_1.ActivatedRoute, router_1.Router])
    ], AzuriranjeOpcijaComponent);
    return AzuriranjeOpcijaComponent;
}());
exports.AzuriranjeOpcijaComponent = AzuriranjeOpcijaComponent;


/***/ }),

/***/ "./src/app/component/hotel/azuriranje-soba/azuriranje-soba.component.css":
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/component/hotel/azuriranje-soba/azuriranje-soba.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"container\" style=\"display: flex; justify-content: center;\">\n    <div class=\"col-md-5 form\">\n        <div class=\"form-area\">  \n            <form role=\"form\"  #formVozilo=\"ngForm\">\n            <br style=\"clear:both\">\n                        <h3 style=\"margin-bottom: 25px; text-align: center;\">Azuriranje/Dodavanje Sobe</h3>\n              <div class=\"form-group\">\n                  <label>Sprat</label>\n                  <input type=\"text\" class=\"form-control\" minlength=\"1\" #naziv=\"ngModel\" id=\"model\" name=\"model\" placeholder=\"Sprat\" required [(ngModel)] = \"soba.sprat\">\n                  <small [hidden]=\"naziv.valid || (naziv.pristine && !formVozilo.submitted)\" class=\"text-danger\">\n                    Sprat je obavezan (veci od nule).\n                  </small>\n              </div>\n              <div class=\"form-group\">\n                <label>Tip</label>\n                <input type=\"text\" class=\"form-control\"  minlength=\"3\"  maxlength=\"30\" #tip=\"ngModel\" id=\"tip\" name=\"tip\" placeholder=\"Tip\" required [(ngModel)] = \"soba.tip\">\n                <small [hidden]=\"tip.valid || (tip.pristine && !formVozilo.submitted)\" class=\"text-danger\">\n                  Tip je obavezan (minimum 3 karaktera a maksimum 30 karaktera).\n                </small>\n              </div>\n              <div class=\"form-group\">\n                  <label>Cena vozila</label>\n                  <input type=\"text\" class=\"form-control\"  #cena=\"ngModel\" id=\"cena\" name=\"cena\" placeholder=\"Cena po danu\" required [(ngModel)] = \"soba.cenaPoDanu\">\n                  <small [hidden]=\"cena.valid || (cena.pristine && !formVozilo.submitted)\" class=\"text-danger\">\n                    Cena po danu je obavezna (pozitivan broj).\n                  </small>\n                </div>\n              <div class=\"form-group\">\n                <label>Broj putnika vozila</label>\n                <input type=\"text\" #brojSedista=\"ngModel\" class=\"form-control\" id=\"sediste\" name=\"sediste\" placeholder=\"Broj kreveta\" required [(ngModel)] = \"soba.brojKreveta\">\n                <small [hidden]=\"brojSedista.valid || (brojSedista.pristine && !formVozilo.submitted)\" class=\"text-danger\">\n                  Broj kreveta je obavezan (pozitivan broj).\n                </small>\n              </div>\n               \n              <div *ngIf=\"isDataAvailable\">\n                <button type=\"button\" [disabled]=\"!formVozilo.valid\" id=\"submit\" name=\"submit\" class=\"btn btn-primary pull-right\" style=\"margin:5px;\" (click) = \"update()\">Azuriraj</button>\n              </div>\n              <div *ngIf=\"!isDataAvailable\">\n                <button type=\"button\" [disabled]=\"!formVozilo.valid\" id=\"submit\" name=\"submit\" class=\"btn btn-primary pull-right\" style=\"margin:5px;\" (click) = \"create()\">Dodaj</button>\n              </div>\n              <button type=\"button\" id=\"submit\" name=\"submit\" class=\"btn btn-primary pull-right\" style=\"margin:5px;\" (click) = \"goBack()\">Odustani</button>\n            </form>\n        </div>\n    </div>\n    </div>"

/***/ }),

/***/ "./src/app/component/hotel/azuriranje-soba/azuriranje-soba.component.ts":
/***/ (function(module, exports, __webpack_require__) {

"use strict";

var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
Object.defineProperty(exports, "__esModule", { value: true });
var core_1 = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
var soba_1 = __webpack_require__("./src/app/model/hotel/soba.ts");
var router_1 = __webpack_require__("./node_modules/@angular/router/esm5/router.js");
var soba_service_1 = __webpack_require__("./src/app/service/hotel/soba.service.ts");
var AzuriranjeSobaComponent = /** @class */ (function () {
    function AzuriranjeSobaComponent(sobaService, route, router) {
        this.sobaService = sobaService;
        this.route = route;
        this.router = router;
        this.soba = new soba_1.Soba();
        this.maksimalnaDuzina = 30;
    }
    AzuriranjeSobaComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.sub = this.route.params.subscribe(function (params) {
            _this.isDataAvailable = false;
            _this.idKompanija = +params['hotel-id'];
            //this.idGaraze = +params['garaza-id'];
            if (params['soba-id'] != null) {
                _this.id = +params['soba-id']; // (+) konvertuje string 'id' u broj
                //id postavljamo kao path parametar pomocu interpolacije stringa  
                if (_this.id != null) {
                    _this.sobaService.findOne(_this.idKompanija, _this.id).subscribe(function (e) {
                        _this.soba = e;
                    });
                    _this.isDataAvailable = true;
                }
                else {
                    //znaci dodajem novi koji ne postoji
                    _this.soba = new soba_1.Soba();
                    _this.isDataAvailable = false;
                }
            }
        });
    };
    AzuriranjeSobaComponent.prototype.create = function () {
        var _this = this;
        var message = this.proveriUnos();
        if (message === "OK") {
            this.sobaService.add(this.idKompanija, this.soba).subscribe(function (s) {
                _this.soba = s;
                _this.router.navigate(['hoteli/' + _this.idKompanija + '/sobe']);
            }, function (err) { return console.log("err"); });
        }
        else {
            alert(message);
        }
    };
    AzuriranjeSobaComponent.prototype.update = function () {
        var _this = this;
        var message = this.proveriUnos();
        if (message === "OK") {
            this.sobaService.update(this.idKompanija, this.soba.id, this.soba).subscribe(function (s) {
                _this.soba = s;
                _this.router.navigate(['hoteli/' + _this.idKompanija + '/sobe']);
            }, function (err) {
                console.log("err");
                if (err.status === 418) {
                    alert("Nije moguce izmeniti zeljenu sobu vec je izmenjeno od strane drugog admina.");
                }
            });
        }
        else {
            alert(message);
        }
    };
    AzuriranjeSobaComponent.prototype.goBack = function () {
        this.router.navigate(['hoteli/' + this.idKompanija + '/sobe']);
    };
    AzuriranjeSobaComponent.prototype.proveriUnos = function () {
        if (this.soba.tip === "" || this.soba.tip.length > this.maksimalnaDuzina) {
            return "Morate popuniti tip koja mora biti kraca od " + this.maksimalnaDuzina + " karaktera";
        }
        if (this.soba.cenaPoDanu <= 0) {
            return "Morate popuniti cenu  po danu koja mora biti pozitivan broj";
        }
        if (this.soba.sprat <= 0) {
            return "Morate popuniti sprat koja mora biti pozitivan broj";
        }
        if (this.soba.brojKreveta <= 0) {
            return "Morate popuniti broj kreveta koja mora biti pozitivan broj";
        }
        return "OK";
    };
    AzuriranjeSobaComponent = __decorate([
        core_1.Component({
            selector: 'app-azuriranje-soba',
            template: __webpack_require__("./src/app/component/hotel/azuriranje-soba/azuriranje-soba.component.html"),
            styles: [__webpack_require__("./src/app/component/hotel/azuriranje-soba/azuriranje-soba.component.css")]
        }),
        __metadata("design:paramtypes", [soba_service_1.SobaService, router_1.ActivatedRoute, router_1.Router])
    ], AzuriranjeSobaComponent);
    return AzuriranjeSobaComponent;
}());
exports.AzuriranjeSobaComponent = AzuriranjeSobaComponent;


/***/ }),

/***/ "./src/app/component/hotel/prikaz-cenovnika/prikaz-cenovnika.component.css":
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/component/hotel/prikaz-cenovnika/prikaz-cenovnika.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"row\">\n    <div class=\"col-md-8 col-sm-offset-2\">\n      </div>\n    <div class=\"col-md-8 col-sm-offset-2\">\n          <div class=\"list-group\">\n            <a class=\"list-group-item\" style=\"min-height: 220px; max-height: 350px;\" *ngFor = \"let i = index; let cenovnik of cenovnici | paginate: { itemsPerPage: 5, currentPage: p }\">\n                  <div class=\"media col-md-3\">\n                      <figure class=\"pull-left\">\n                          <img class=\"media-object img-rounded img-responsive\"  src=\"assets/cenovnik.jpg\" alt=\"placehold.it/350x250\" >\n                      </figure>\n                  </div>\n                  <div class=\"col-md-6\">\n                      <h4 class=\"list-group-item-text\">Pocetni Datum: {{cenovnik.pocetniDatum}}</h4>\n                      <h4 class=\"list-group-item-text\">Krajnji Datum: {{cenovnik.krajnjiDatum}}</h4>\n                      <h4 class=\"list-group-item-text\">Cena: {{cenovnik.cena}}</h4>\n                  </div>\n                  <div class=\"col-md-3 text-center centered-button\" style=\"vertical-align: middle;\">\n                      <button *ngIf=\"obrisiVoziloVidljivo(cenovnik)\" type=\"button\" class=\"btn btn-default btn-lg btn-block\" (click) = \"delete(cenovnik.id)\">Obrisi</button>\n                      <button *ngIf=\"azurirajVoziloVidljivo(cenovnik)\" type=\"button\" class=\"btn btn-default btn-lg btn-block\" (click) = \"update(cenovnik.id)\">Izmeni</button>\n                  </div>\n            </a>\n          </div>\n      <div class=\"item col-lg-10 col-lg-10\" style=\"width: 100%; text-align: center;\">\n          <pagination-controls (pageChange)=\"p = $event\"></pagination-controls>\n      </div>\n    </div>\n  </div>"

/***/ }),

/***/ "./src/app/component/hotel/prikaz-cenovnika/prikaz-cenovnika.component.ts":
/***/ (function(module, exports, __webpack_require__) {

"use strict";

var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
Object.defineProperty(exports, "__esModule", { value: true });
var core_1 = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
var cenovnik_service_1 = __webpack_require__("./src/app/service/hotel/cenovnik.service.ts");
var router_1 = __webpack_require__("./node_modules/@angular/router/esm5/router.js");
var auth_service_1 = __webpack_require__("./src/app/auth.service.ts");
var PrikazCenovnikaComponent = /** @class */ (function () {
    function PrikazCenovnikaComponent(cenovnikService, router, route, authService) {
        this.cenovnikService = cenovnikService;
        this.router = router;
        this.route = route;
        this.authService = authService;
        this.cenovnici = [];
        this.dropdownSettings = {};
        this.min = new Date();
        this.idRezervacije = 0;
        var res = localStorage.getItem('token');
        if (res != null) {
            //this.tipkorisnika = this.authService.getRoles(res);
        }
        else {
            this.tipkorisnika = "nema_korisnika";
        }
    }
    PrikazCenovnikaComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.sub = this.route.params.subscribe(function (params) {
            _this.isDataAvailable = false;
            if (params['hotel-id'] != null) {
                _this.id = +params['hotel-id']; // (+) konvertuje string 'id' u broj
                //id postavljamo kao path parametar pomocu interpolacije stringa
                _this.sobaId = +params['soba-id'];
                if (_this.id != null) {
                    /*this.voziloService.findVozilaForRent(this.id).subscribe(
                      e =>
                      {
                        this.vozila = e;
                      }
                    )*/
                    _this.getAll();
                }
            }
        });
    };
    PrikazCenovnikaComponent.prototype.getAll = function () {
        var _this = this;
        this.cenovnikService.findAll(this.id, this.sobaId).subscribe(function (s) { _this.cenovnici = s; });
    };
    PrikazCenovnikaComponent.prototype.update = function (id) {
        this.router.navigate(['hoteli/' + this.id + '/sobe/' + this.sobaId + '/cenovnici/add/' + id]);
    };
    PrikazCenovnikaComponent.prototype.delete = function (id) {
        var _this = this;
        this.cenovnikService.delete(this.id, this.sobaId, id).subscribe(function (s) { return _this.getAll(); }, function (err) { return console.log("err"); });
    };
    PrikazCenovnikaComponent.prototype.obrisiVoziloVidljivo = function (vozilo) {
        /*if(!vozilo.dozvoljenoBrisanjeIzmena){
          return false;
        }*/
        // if(this.tipkorisnika === "ROLE_Administrator_rent_a_car_servisa"){
        //   return true;
        // }
        // return false; 
        return true;
    };
    PrikazCenovnikaComponent.prototype.azurirajVoziloVidljivo = function (vozilo) {
        /*if(!vozilo.dozvoljenoBrisanjeIzmena){
          return false;
        }*/
        // if(this.tipkorisnika === "ROLE_Administrator_rent_a_car_servisa"){
        //   return true;
        // }
        // return false;
        return true;
    };
    PrikazCenovnikaComponent = __decorate([
        core_1.Component({
            selector: 'app-prikaz-cenovnika',
            template: __webpack_require__("./src/app/component/hotel/prikaz-cenovnika/prikaz-cenovnika.component.html"),
            styles: [__webpack_require__("./src/app/component/hotel/prikaz-cenovnika/prikaz-cenovnika.component.css")]
        }),
        __metadata("design:paramtypes", [cenovnik_service_1.CenovnikService, router_1.Router, router_1.ActivatedRoute,
            auth_service_1.AuthService])
    ], PrikazCenovnikaComponent);
    return PrikazCenovnikaComponent;
}());
exports.PrikazCenovnikaComponent = PrikazCenovnikaComponent;


/***/ }),

/***/ "./src/app/component/hotel/prikaz-hotela/prikaz-hotela.component.css":
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/component/hotel/prikaz-hotela/prikaz-hotela.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"row\">\n    <div *ngIf = \"vidjivoBrzeRezervacije()\" class=\"col-md-8 col-sm-offset-4 brzaRezervacija\">\n        <img style=\"max-width: 100%; height: 200px;\" class=\"img-fluid\" (click) = \"brzaRezervacija()\" src=\"assets/hotel/SALE.jpg\"/>\n    </div>\n  <!-- <div class=\"col-md-8 col-sm-offset-2\" style=\"margin-bottom: 15px;\">\n        <form class=\"md-form mr-auto mb-4\">\n                <table class=\"table table-striped\">\n            <tbody>\n                <tr>\n                    <td>\n                        <label>Adresa servisa</label>\n                    <ng-multiselect-dropdown [placeholder]=\"'Adresa'\" [data]=\"adreseRenta\" [(ngModel)]=\"izabranaAdresa\" [settings]=\"dropdownSettings\" [ngModelOptions]=\"{standalone: true}\">\n                    </ng-multiselect-dropdown>\n                </td>\n                <td>\n                    <label>Naziv servisa</label>\n                    <ng-multiselect-dropdown [placeholder]=\"'Naziv'\" [data]=\"naziviRenta\" [(ngModel)]=\"izabraniNaziv\" [settings]=\"dropdownSettings\" [ngModelOptions]=\"{standalone: true}\">\n                    </ng-multiselect-dropdown>\n                </td>\n                <td>\n                        <input class=\"form-control mr-sm-2\" style=\"margin-top:24px;\" type=\"button\" value=\"Trazi\" aria-label=\"Search\" (click) = \"trazi()\">\n                </td>\n            </tr>\n    </table>\n      </form>\n  </div> -->\n    <div class=\"col-md-8 col-sm-offset-2\">\n          <div class=\"list-group\">\n            <a class=\"list-group-item\" style=\"min-height: 220px; max-height: 350px;\" *ngFor = \"let i = index; let hotel of hoteli | paginate: { itemsPerPage: 5, currentPage: p }\">\n                  <div class=\"media col-md-3\">\n                      <figure class=\"pull-left\">\n                          <img class=\"media-object img-rounded img-responsive\"  src=\"assets/hotel.jpg\" alt=\"placehold.it/350x250\" (click)=\"viewDetails(hotel.id)\">\n                      </figure>\n                  </div>\n                  <div class=\"col-md-6\">\n                    <a (click)=\"getAllSort('naziv')\">{{hotel.naziv}} </a>\n                    <a (click)=\"getAllSort('adresa')\"> <small><i>{{hotel.adresaDTO.zemlja}}</i></small> <small><i>{{hotel.adresaDTO.grad}}</i></small> \n                      <small><i>{{hotel.adresaDTO.ulica}}</i></small> <small><i>{{hotel.adresaDTO.broj}}</i></small></a>\n                    <span class=\"glyphicon glyphicon-map-marker\" (click) = \"pokaziMapu(hotel.longitude, hotel.latitude)\" ></span>\n                    <p class=\"group inner list-group-item-text\">\n                      {{hotel.opis}}</p>\n                  </div>\n                  <div *ngIf=\"ulogovaniKorisnikImaDozvoluDaBrise()\" class=\"col-md-2\" style=\"margin-top: 5px; padding: 0px;\">\n                    <span class=\"glyphicon glyphicon-trash\" (click) = \"delete(hotel.id)\"></span>\n                </div>\n                <div *ngIf=\"ulogovaniKorisnikImaDozvoluDaMenja()\" class=\"col-md-2\" style=\"margin-top: 5px; padding: 0px;\">\n                    <span class=\"glyphicon glyphicon-wrench\" (click) = \"update(hotel.id)\"></span>\n                </div>\n                <button *ngIf=\"ulogovaniKorisnikImaDozvoluDaMenja()\" (click) = \"createOption(hotel.id)\" >Kreiraj Opciju\n                </button>\n                <button *ngIf=\"ulogovaniKorisnikImaDozvoluDaMenja()\" (click) = \"createRoom(hotel.id)\" >Kreiraj Sobu\n                  </button>\n                  <button *ngIf=\"ulogovaniKorisnikImaDozvoluDaMenja()\" (click) = \"viewOption(hotel.id)\" >Vidi Opcije\n                    </button>\n            </a>\n          </div>\n          \n      <div class=\"item col-lg-10 col-lg-10\" style=\"width: 100%; text-align: center;\">\n          <pagination-controls (pageChange)=\"p = $event\"></pagination-controls>\n      </div>\n    </div>\n  </div>"

/***/ }),

/***/ "./src/app/component/hotel/prikaz-hotela/prikaz-hotela.component.ts":
/***/ (function(module, exports, __webpack_require__) {

"use strict";

var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
Object.defineProperty(exports, "__esModule", { value: true });
var core_1 = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
var router_1 = __webpack_require__("./node_modules/@angular/router/esm5/router.js");
var auth_service_1 = __webpack_require__("./src/app/auth.service.ts");
var hotel_service_1 = __webpack_require__("./src/app/service/hotel/hotel.service.ts");
var PrikazHotelaComponent = /** @class */ (function () {
    function PrikazHotelaComponent(route, hotelService, router, authService) {
        this.route = route;
        this.hotelService = hotelService;
        this.router = router;
        this.authService = authService;
        this.hoteli = [];
        this.adreseRenta = [];
        this.pomAdreseRenta = [];
        this.naziviRenta = [];
        this.dropdownSettings = {};
        this.izabranaAdresa = "";
        this.izabraniNaziv = "";
        this.paramDir = "ASC";
        this.idRezervacije = 0;
        this.idFilijala = 0;
        var res = localStorage.getItem('token');
        if (res != null) {
            //this.tipkorisnika = this.authService.getRoles(res);
        }
        else {
            this.tipkorisnika = "nema_korisnika";
        }
        this.getAll();
    }
    PrikazHotelaComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.hotelService.vratiSveAdrese().subscribe(function (s) {
            s.forEach(function (item) {
                var temp = item.zemlja + " " + item.grad + " " + item.ulica + " " + item.broj;
                _this.pomAdreseRenta.push(temp);
            });
            _this.adreseRenta = _this.pomAdreseRenta;
        });
        this.hotelService.vratiSveNazive().subscribe(function (a) {
            _this.naziviRenta = a;
        });
        this.dropdownSettings = {
            singleSelection: true,
            // idField: 'id',
            //textField: 'adreseRenta',
            itemsShowLimit: 3,
            allowSearchFilter: true
        };
        /* this.route.queryParams.subscribe(params => {
           if(params["idRezervacije"] !== undefined){
             this.idRezervacije = params["idRezervacije"];
           }
         });*/
    };
    PrikazHotelaComponent.prototype.getAll = function () {
        var _this = this;
        /*if(this.tipkorisnika !== "nema_korisnika"){
          this.rentacarService.vratiListuOcenjivihServisa().subscribe(
            a =>
            {
              this.ocenjiviRentovi = a;
              this.rentacarService.findAll().subscribe(
            
                s => {
                  this.rentacarovi = s;
                }
              );
            }
          );
        }*/
        //else{
        this.hotelService.findAll().subscribe(function (s) {
            _this.hoteli = s;
        });
        // }
    };
    PrikazHotelaComponent.prototype.delete = function (id) {
        var _this = this;
        this.hotelService.delete(id).subscribe(function (s) { return _this.getAll(); }, function (err) { return console.log("err"); });
    };
    PrikazHotelaComponent.prototype.update = function (id) {
        this.router.navigate(['hoteli/add', id]);
    };
    PrikazHotelaComponent.prototype.postaviFilijalu = function (id) {
        this.idFilijala = id;
    };
    PrikazHotelaComponent.prototype.viewDetails = function (id) {
        //if(this.idFilijala != 0){
        this.router.navigate(['hoteli/' + id + '/sobe']);
        /*}
        else{
          alert('izaberi filjalu');
        }*/
    };
    PrikazHotelaComponent.prototype.createRoom = function (id) {
        this.router.navigate(['hoteli/' + id + '/sobe/add']);
    };
    PrikazHotelaComponent.prototype.createOption = function (id) {
        this.router.navigate(['hoteli/' + id + '/opcije/add']);
    };
    PrikazHotelaComponent.prototype.viewOption = function (id) {
        this.router.navigate(['hoteli/' + id + '/opcije']);
    };
    PrikazHotelaComponent.prototype.imageClick = function (id) {
        /*if(this.idRezervacije !== 0){
          let navigationExtras: NavigationExtras = {
            queryParams: {
                "idRezervacije" : this.idRezervacije
            }
          };
          this.router.navigate(['rentacarovi/' +  id + '/prikazVozila'], navigationExtras);
        }
        else {
          this.router.navigate(['rentacarovi/' +  id + '/prikazVozila']);
        }*/
    };
    PrikazHotelaComponent.prototype.spanClick = function (id) {
        //this.router.navigate(['rentacarovi/' +  id + '/prikazFilijala']);
    };
    PrikazHotelaComponent.prototype.ulogovaniKorisnikImaDozvoluDaMenja = function () {
        /*if( this.tipkorisnika === "ROLE_Administrator_rent_a_car_servisa" || this.tipkorisnika === "ROLE_Administrator_sistema"){
          return true;
        }
        return false; */
        return true;
    };
    PrikazHotelaComponent.prototype.ulogovaniKorisnikImaDozvoluDaBrise = function () {
        // if(this.tipkorisnika === "ROLE_Administrator_sistema"){
        //   return true;
        // }
        // return false; 
        return true;
    };
    PrikazHotelaComponent.prototype.rezervisiDugme = function () {
        if (this.tipkorisnika === "ROLE_Registrovani_korisnik") {
            return true;
        }
        return false;
    };
    PrikazHotelaComponent.prototype.ocenaVidljivo = function () {
        if (this.tipkorisnika === "ROLE_Registrovani_korisnik") {
            return true;
        }
        return false;
    };
    PrikazHotelaComponent.prototype.trazi = function () {
        // this.rentacarService.trazenjeRentacarova(this.izabraniNaziv, this.izabranaAdresa).subscribe(
        //   s => {
        //     this.rentacarovi = s;
        //   },
        //   err=> console.log("err")
        // );    
    };
    PrikazHotelaComponent.prototype.getAllSort = function (paramSort) {
        var _this = this;
        this.hotelService.findAllSort(paramSort, this.paramDir).subscribe(function (ss) { _this.hoteli = ss; });
        if (this.paramDir === 'ASC') {
            this.paramDir = 'DESC';
        }
        else {
            this.paramDir = 'ASC';
        }
    };
    PrikazHotelaComponent.prototype.brzaRezervacija = function () {
        var navigationExtras = {
            queryParams: {
                "idRezervacije": this.idRezervacije
            }
        };
        this.router.navigate(['rentacarovi/brzaRezervacijaVozila'], navigationExtras);
    };
    PrikazHotelaComponent.prototype.daLiSmeDaOceni = function (id) {
        if (this.ocenjiviRentovi.indexOf(id) > -1) {
            return false;
        }
        else {
            return true;
        }
    };
    PrikazHotelaComponent.prototype.oceniServis = function (rentacar) {
        /*if(rentacar.ulogovanogKorisnikaOcena > 0){
          let ocena: OcenaRenta = new OcenaRenta();
          ocena.rentACar = rentacar;
          ocena.ocenaRenta = rentacar.ulogovanogKorisnikaOcena;
          this.rentacarService.oceniServis(1, ocena).subscribe(
            ajde =>
            {
            }
          )
        }*/
    };
    PrikazHotelaComponent.prototype.pokaziMapu = function (longitude, latitude) {
        //this.router.navigate(['prikaziMapu/' + longitude + "/" + latitude]);
    };
    PrikazHotelaComponent.prototype.vidjivoBrzeRezervacije = function () {
        if (this.tipkorisnika === "ROLE_Registrovani_korisnik" && this.idRezervacije !== 0) {
            return true;
        }
        return false;
    };
    PrikazHotelaComponent = __decorate([
        core_1.Component({
            selector: 'app-prikaz-hotela',
            template: __webpack_require__("./src/app/component/hotel/prikaz-hotela/prikaz-hotela.component.html"),
            styles: [__webpack_require__("./src/app/component/hotel/prikaz-hotela/prikaz-hotela.component.css")]
        }),
        __metadata("design:paramtypes", [router_1.ActivatedRoute, hotel_service_1.HotelService, router_1.Router, auth_service_1.AuthService])
    ], PrikazHotelaComponent);
    return PrikazHotelaComponent;
}());
exports.PrikazHotelaComponent = PrikazHotelaComponent;


/***/ }),

/***/ "./src/app/component/hotel/prikaz-opcija/prikaz-opcija.component.css":
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/component/hotel/prikaz-opcija/prikaz-opcija.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"row\">\n\n    <div class=\"col-md-8 col-sm-offset-2\">\n      </div>\n    <div class=\"col-md-8 col-sm-offset-2\">\n          <div class=\"list-group\">\n            <a class=\"list-group-item\" style=\"min-height: 220px; max-height: 350px;\" *ngFor = \"let i = index; let opcija of opcije | paginate: { itemsPerPage: 5, currentPage: p }\">\n                  <div class=\"media col-md-3\">\n                      <figure class=\"pull-left\">\n                          <img class=\"media-object img-rounded img-responsive\"  src=\"assets/opcija.jpg\" alt=\"placehold.it/350x250\" >\n                      </figure>\n                  </div>\n                  <div class=\"col-md-6\">\n                      <h4 class=\"list-group-item-text\">Naziv: {{opcija.naziv}}</h4>\n                      <h4 class=\"list-group-item-text\">Cena: {{opcija.cena}}</h4>\n                  </div>\n                  <div class=\"col-md-3 text-center centered-button\" style=\"vertical-align: middle;\">\n                      <button *ngIf=\"obrisiVoziloVidljivo(vozilo)\" type=\"button\" class=\"btn btn-default btn-lg btn-block\" (click) = \"delete(opcija.id)\">Obrisi</button>\n                      <button *ngIf=\"azurirajVoziloVidljivo(vozilo)\" type=\"button\" class=\"btn btn-default btn-lg btn-block\" (click) = \"update(opcija.id)\">Izmeni</button>\n                  </div>\n            </a>\n          </div>\n      <div class=\"item col-lg-10 col-lg-10\" style=\"width: 100%; text-align: center;\">\n          <pagination-controls (pageChange)=\"p = $event\"></pagination-controls>\n      </div>\n    </div>\n  </div>"

/***/ }),

/***/ "./src/app/component/hotel/prikaz-opcija/prikaz-opcija.component.ts":
/***/ (function(module, exports, __webpack_require__) {

"use strict";

var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
Object.defineProperty(exports, "__esModule", { value: true });
var core_1 = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
var opcija_service_1 = __webpack_require__("./src/app/service/hotel/opcija.service.ts");
var router_1 = __webpack_require__("./node_modules/@angular/router/esm5/router.js");
var auth_service_1 = __webpack_require__("./src/app/auth.service.ts");
var PrikazOpcijaComponent = /** @class */ (function () {
    function PrikazOpcijaComponent(opcijeService, router, route, authService) {
        this.opcijeService = opcijeService;
        this.router = router;
        this.route = route;
        this.authService = authService;
        this.opcije = [];
        this.dropdownSettings = {};
        this.min = new Date();
        this.idRezervacije = 0;
        var res = localStorage.getItem('token');
        if (res != null) {
            //this.tipkorisnika = this.authService.getRoles(res);
        }
        else {
            this.tipkorisnika = "nema_korisnika";
        }
    }
    PrikazOpcijaComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.sub = this.route.params.subscribe(function (params) {
            _this.isDataAvailable = false;
            if (params['hotel-id'] != null) {
                _this.id = +params['hotel-id']; // (+) konvertuje string 'id' u broj
                //id postavljamo kao path parametar pomocu interpolacije stringa
                if (_this.id != null) {
                    /*this.voziloService.findVozilaForRent(this.id).subscribe(
                      e =>
                      {
                        this.vozila = e;
                      }
                    )*/
                    _this.getAll();
                }
            }
        });
    };
    PrikazOpcijaComponent.prototype.getAll = function () {
        var _this = this;
        this.opcijeService.findAll(this.id).subscribe(function (s) { _this.opcije = s; });
    };
    PrikazOpcijaComponent.prototype.update = function (id) {
        this.router.navigate(['hoteli/' + this.id + '/opcije/add/' + id]);
    };
    PrikazOpcijaComponent.prototype.delete = function (id) {
        var _this = this;
        this.opcijeService.delete(this.id, id).subscribe(function (s) { return _this.getAll(); }, function (err) { return console.log("err"); });
    };
    PrikazOpcijaComponent.prototype.obrisiVoziloVidljivo = function (vozilo) {
        /*if(!vozilo.dozvoljenoBrisanjeIzmena){
          return false;
        }*/
        // if(this.tipkorisnika === "ROLE_Administrator_rent_a_car_servisa"){
        //   return true;
        // }
        // return false; 
        return true;
    };
    PrikazOpcijaComponent.prototype.azurirajVoziloVidljivo = function (vozilo) {
        /*if(!vozilo.dozvoljenoBrisanjeIzmena){
          return false;
        }*/
        // if(this.tipkorisnika === "ROLE_Administrator_rent_a_car_servisa"){
        //   return true;
        // }
        // return false; 
        return true;
    };
    PrikazOpcijaComponent = __decorate([
        core_1.Component({
            selector: 'app-prikaz-opcija',
            template: __webpack_require__("./src/app/component/hotel/prikaz-opcija/prikaz-opcija.component.html"),
            styles: [__webpack_require__("./src/app/component/hotel/prikaz-opcija/prikaz-opcija.component.css")]
        }),
        __metadata("design:paramtypes", [opcija_service_1.OpcijaService, router_1.Router, router_1.ActivatedRoute,
            auth_service_1.AuthService])
    ], PrikazOpcijaComponent);
    return PrikazOpcijaComponent;
}());
exports.PrikazOpcijaComponent = PrikazOpcijaComponent;


/***/ }),

/***/ "./src/app/component/hotel/prikaz-soba/prikaz-soba.component.css":
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/component/hotel/prikaz-soba/prikaz-soba.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"row\">\n    <div class=\"col-md-8 col-sm-offset-2\">\n            <button *ngIf=\"dodajAdminaVidljivo()\" style=\"width: auto; float: right;\" class=\"form-control mr-sm-5\" (click) = \"dodajAdministratora()\">Dodaj administratora hotela</button>\n        <button *ngIf=\"dodajVoziloVidljivo()\" style=\"width: auto; float: right;\" class=\"form-control mr-sm-5\" (click) = \"izvestajPoslovanja()\">Izvestaj o poslovanju</button>\n    </div>\n  <div class=\"col-md-8 col-sm-offset-2\">\n        <div class=\"list-group\">\n          <a class=\"list-group-item\" style=\"min-height: 220px; max-height: 350px;\" *ngFor = \"let i = index; let soba of sobe | paginate: { itemsPerPage: 5, currentPage: p }\">\n                <div class=\"media col-md-3\">\n                    <figure class=\"pull-left\">\n                        <img class=\"media-object img-rounded img-responsive\"  src=\"assets/soba.jpg\" alt=\"placehold.it/350x250\" (click)='prikaziCenovnike(soba.id)'>\n                    </figure>\n                </div>\n                <div class=\"col-md-6\">\n                    <h3 class=\"list-group-item-text\">Tip: {{soba.tip}}</h3>\n                    <h4 class=\"list-group-item-text\">Sprat: {{soba.sprat}}</h4>\n                    <h4 class=\"list-group-item-text\">Broj kreveta: {{soba.brojKreveta}}</h4>\n                    <h4 class=\"list-group-item-text\">Cena: {{soba.cenaPoDanu}}$</h4>\n                    <h4 class=\"list-group-item-text\">Ocena: {{soba.prosecnaOcena}} <small> / </small> 5 </h4>\n                </div>\n                <!-- <div class=\"col-md-3 text-center centered\">\n                    <button *ngIf=\"rezervisiDugme()\" type=\"button\" class=\"btn btn-default btn-lg btn-block\" (click)=\"rezervisiVozilo(vozilo.id)\"> Rezervisi </button>\n                </div> -->\n                <div class=\"col-md-3 text-center centered-button\" style=\"vertical-align: middle;\">\n                    <button *ngIf=\"obrisiVoziloVidljivo(vozilo)\" type=\"button\" class=\"btn btn-default btn-lg btn-block\" (click) = \"delete(soba)\">Obrisi</button>\n                    <button *ngIf=\"azurirajVoziloVidljivo(vozilo)\" type=\"button\" class=\"btn btn-default btn-lg btn-block\" (click) = \"update(soba.id)\">Izmeni</button>\n                    <button *ngIf=\"azurirajVoziloVidljivo(vozilo)\" type=\"button\" class=\"btn btn-default btn-lg btn-block\" (click) = \"createCenovnik(soba.id)\">Kreiraj cenovnik</button>\n                </div>\n          </a>\n        </div>\n\n  </div>\n  <div class=\"col-md-8 col-sm-offset-2\">\n        <ng5-slider [(value)]=\"minValue\" [(highValue)]=\"maxValue\" [options]=\"options\"></ng5-slider>\n        <form class=\"md-form mr-auto mb-4\">\n            <table class=\"table table-striped\">\n                <tbody>\n                    <tr>\n                        <td>\n                            <label> Pocetni Datum </label>\n                            <input class=\"form-control mr-sm-2\" style=\"width: auto;\" placeholder=\"Date:\" \n                                    [min]=\"min\"\n                                    [(ngModel)]=\"rezervacijaSobe.pocetniDatum\"\n                                    [owlDateTimeTrigger]=\"dt1\" [owlDateTime]=\"dt1\"  [ngModelOptions]=\"{standalone: true}\">\n                            <owl-date-time [pickerType]=\"'calendar'\" #dt1></owl-date-time>\n                          </td>\n                          <td>\n                            <label> krajnji Datum </label>\n                            <input class=\"form-control mr-sm-2\" style=\"width: auto;\" placeholder=\"Date:\"\n                                    [min]=\"min\" \n                                    [(ngModel)]=\"rezervacijaSobe.krajnjiDatum\"\n                                    [owlDateTimeTrigger]=\"dt2\" [owlDateTime]=\"dt2\"  [ngModelOptions]=\"{standalone: true}\">\n                            <owl-date-time [pickerType]=\"'calendar'\" #dt2></owl-date-time>\n                          </td>\n                        <td>\n                            <label>Broj gostiju</label> \n                            <input class=\"form-control mr-sm-2\" style=\"width: auto;\" type=\"text\" placeholder=\"Broj gostiju\" aria-label=\"Search\" [(ngModel)] = \"rezervacijaSobe.brojGostiju\" [ngModelOptions]=\"{standalone: true}\" >\n                        </td>\n                        <td>\n                            <label>Tip sobe</label>\n                            <ng-multiselect-dropdown [placeholder]=\"'Tip sobe'\" [data]=\"tipoviSoba\" [(ngModel)]=\"rezervacijaSobe.tipSobe\" [settings]=\"dropdownSettings\" [ngModelOptions]=\"{standalone: true}\">\n                            </ng-multiselect-dropdown>\n                        </td>\n                        <td>\n                            <input style=\"margin-top: 24px;\" class=\"form-control mr-sm-2\" type=\"button\" value=\"Trazi\" aria-label=\"Search\" (click) = \"trazi()\">\n                        </td>\n                  </tr>\n                </tbody>\n            </table>\n        </form>\n        \n    </div>\n\n    <div class=\"item col-lg-10 col-lg-10\" style=\"width: 100%; text-align: center;\">\n            <pagination-controls (pageChange)=\"p = $event\"></pagination-controls>\n        </div>\n</div>\n"

/***/ }),

/***/ "./src/app/component/hotel/prikaz-soba/prikaz-soba.component.ts":
/***/ (function(module, exports, __webpack_require__) {

"use strict";

var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
Object.defineProperty(exports, "__esModule", { value: true });
var core_1 = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
var router_1 = __webpack_require__("./node_modules/@angular/router/esm5/router.js");
var auth_service_1 = __webpack_require__("./src/app/auth.service.ts");
var soba_service_1 = __webpack_require__("./src/app/service/hotel/soba.service.ts");
var zakupSoba_1 = __webpack_require__("./src/app/model/hotel/zakupSoba.ts");
var ng5_slider_1 = __webpack_require__("./node_modules/ng5-slider/esm5/ng5-slider.js");
var PrikazSobaComponent = /** @class */ (function () {
    function PrikazSobaComponent(voziloService, router, route, authService) {
        this.voziloService = voziloService;
        this.router = router;
        this.route = route;
        this.authService = authService;
        this.sobe = [];
        this.rezervacijaSobe = new zakupSoba_1.ZakupSoba();
        this.dropdownSettings = {};
        this.min = new Date();
        this.idRezervacije = 0;
        this.minValue = 100;
        this.maxValue = 400;
        this.options = {
            floor: this.minValue,
            ceil: this.maxValue,
            translate: function (value, label) {
                switch (label) {
                    case ng5_slider_1.LabelType.Low:
                        return '<b>Min price:</b> $' + value;
                    case ng5_slider_1.LabelType.High:
                        return '<b>Max price:</b> $' + value;
                    default:
                        return '$' + value;
                }
            }
        };
        var res = localStorage.getItem('token');
        if (res != null) {
            //this.tipkorisnika = this.authService.getRoles(res);
        }
        else {
            this.tipkorisnika = "nema_korisnika";
        }
    }
    PrikazSobaComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.sub = this.route.params.subscribe(function (params) {
            _this.isDataAvailable = false;
            if (params['hotel-id'] != null) {
                _this.id = +params['hotel-id']; // (+) konvertuje string 'id' u broj
                //id postavljamo kao path parametar pomocu interpolacije stringa
                //this.garazaId = +params['garaza-id'];
                if (_this.id != null) {
                    _this.voziloService.findAll(_this.id).subscribe(function (e) {
                        _this.sobe = e;
                    });
                    /*this.voziloService.vratiSveTipove().subscribe(
                      s =>
                      {
                        this.tipoviVozila = s;
                      }
                    )
          
                    this.filijalaService.vratiFilijaleForRent(this.id).subscribe(
                      a =>
                      {
                        this.mestaFilijala = a;
                      }
                    )*/
                    _this.dropdownSettings = {
                        singleSelection: true,
                        // idField: 'id',
                        // textField: 'tipoviVozila',
                        itemsShowLimit: 3,
                        allowSearchFilter: true
                    };
                    /*this.voziloService.minimalnaCenaVozila().subscribe(
                      succ =>
                      {
                        this.minValue = succ;
          
                        this.voziloService.maksimalnaCenaVozila().subscribe(
                          success =>
                          {
                            this.maxValue = success;
              
                            this.options =  {
                              floor: this.minValue,
                              ceil: this.maxValue,
                              translate: (value: number, label: LabelType): string => {
                                switch (label) {
                                  case LabelType.Low:
                                    return '<b>Min price:</b> $' + value;
                                  case LabelType.High:
                                    return '<b>Max price:</b> $' + value;
                                  default:
                                    return '$' + value;
                                }
                              }
                            };
                          }
                        )
                      }
                    ) */
                }
            }
        });
        // this.route.queryParams.subscribe(params => {
        //   if(params["idRezervacije"] !== undefined){
        //     this.idRezervacije = params["idRezervacije"];
        //   }
        // });
    };
    PrikazSobaComponent.prototype.getAll = function () {
        var _this = this;
        this.voziloService.findAll(this.id).subscribe(function (s) { _this.sobe = s; });
    };
    PrikazSobaComponent.prototype.delete = function (vozilo) {
        var _this = this;
        this.voziloService.delete(this.id, vozilo.id).subscribe(function (s) {
            _this.ngOnInit();
            //this.router.navigate(['hoteli/' + soba.hotel.id + '/prikazSoba']);
        }, function (err) { return console.log("err"); });
    };
    PrikazSobaComponent.prototype.update = function (id) {
        this.router.navigate(['hoteli/' + this.id + '/sobe/add/' + id]);
    };
    PrikazSobaComponent.prototype.add = function (id) {
        this.router.navigate(['hoteli/' + this.id + '/sobe/add']);
    };
    // rezervisiDugme(){
    //   if(this.tipkorisnika === "ROLE_Registrovani_korisnik" && this.idRezervacije !==0){
    //     return true;
    //   }
    //   return false; 
    // }
    PrikazSobaComponent.prototype.obrisiVoziloVidljivo = function (vozilo) {
        /*if(!vozilo.dozvoljenoBrisanjeIzmena){
          return false;
        }*/
        // if(this.tipkorisnika === "ROLE_Administrator_rent_a_car_servisa"){
        //   return true;
        // }
        // return false; 
        return true;
    };
    PrikazSobaComponent.prototype.azurirajVoziloVidljivo = function (vozilo) {
        /*if(!vozilo.dozvoljenoBrisanjeIzmena){
          return false;
        }*/
        // if(this.tipkorisnika === "ROLE_Administrator_rent_a_car_servisa"){
        //   return true;
        // }
        // return false; 
        return true;
    };
    PrikazSobaComponent.prototype.dodajVoziloVidljivo = function () {
        // if(this.tipkorisnika === "ROLE_Administrator_rent_a_car_servisa"){
        //   return true;
        // }
        // return false; 
        return true;
    };
    PrikazSobaComponent.prototype.dodajAdminaVidljivo = function () {
        // if(this.tipkorisnika === "ROLE_Administrator_sistema"){
        //   return true;
        // }
        // return false; 
        return true;
    };
    PrikazSobaComponent.prototype.ocenaVidljivo = function () {
        // if(this.tipkorisnika === "ROLE_Registrovani_korisnik"){
        //   return true;
        // }
        // return false; 
        return true;
    };
    PrikazSobaComponent.prototype.vidljivoPretraga = function () {
        // if(this.tipkorisnika === "ROLE_Registrovani_korisnik" || this.tipkorisnika === "nema_korisnika"){
        //   return true;
        // }
        // return false; 
        return true;
    };
    PrikazSobaComponent.prototype.prikaziCenovnike = function (sobaId) {
        this.router.navigate(['hoteli/' + this.id + '/sobe/' + sobaId + '/cenovnici']);
    };
    PrikazSobaComponent.prototype.createCenovnik = function (sobaId) {
        this.router.navigate(['hoteli/' + this.id + '/sobe/' + sobaId + '/cenovnici/add']);
    };
    PrikazSobaComponent.prototype.trazi = function () {
        /*let rezervacija = new RezervacijaVozila()
        if(this.proveriRezervaciju())
        {
          rezervacija.datumPreuzimanja = this.konvertujUDobroVreme(this.rezervacijaVozila.datumPreuzimanja.toString().substring(4,15));
          rezervacija.datumVracanja = this.konvertujUDobroVreme(this.rezervacijaVozila.datumVracanja.toString().substring(4,15));
          rezervacija.tipVozila = this.rezervacijaVozila.tipVozila.toString();
          rezervacija.mestoPreuzimanja = this.rezervacijaVozila.mestoPreuzimanja.toString();
          rezervacija.mestoVracanja = this.rezervacijaVozila.mestoVracanja.toString();
          rezervacija.brojPutnika = this.rezervacijaVozila.brojPutnika;
          rezervacija.minimalnaCena = this.minValue;
          rezervacija.maksimalnaCena = this.maxValue;
          this.voziloService.traziVozilo(rezervacija, this.id).subscribe(
            s => {
              this.vozila = s;
            },
            err=> console.log("err")
          );
          }
          else{
            alert("morate uneti datum preuzimanja i vracanja, mesto preuzimanja i broj putnika veci od 0");
          }*/
    };
    PrikazSobaComponent.prototype.konvertujUDobroVreme = function (primljeniString) {
        var pravoVreme;
        pravoVreme = primljeniString.substring(7, 11) + "/" + primljeniString.substring(0, 3) + "/" + primljeniString.substring(4, 6);
        pravoVreme = this.mesecPrebaciUbroj(pravoVreme);
        //alert(pravoVreme)
        return pravoVreme;
    };
    PrikazSobaComponent.prototype.mesecPrebaciUbroj = function (primljeniString) {
        primljeniString = primljeniString.replace("Jan", "01");
        primljeniString = primljeniString.replace("Feb", "02");
        primljeniString = primljeniString.replace("Mar", "03");
        primljeniString = primljeniString.replace("Apr", "04");
        primljeniString = primljeniString.replace("May", "05");
        primljeniString = primljeniString.replace("Jun", "06");
        primljeniString = primljeniString.replace("Jul", "07");
        primljeniString = primljeniString.replace("Aug", "08");
        primljeniString = primljeniString.replace("Sep", "09");
        primljeniString = primljeniString.replace("Oct", "10");
        primljeniString = primljeniString.replace("Nov", "11");
        primljeniString = primljeniString.replace("Dec", "12");
        return primljeniString;
    };
    PrikazSobaComponent.prototype.proveriRezervaciju = function () {
        /*if(this.rezervacijaVozila.datumPreuzimanja === "")
          return false;
        if(this.rezervacijaVozila.datumVracanja === "")
          return false;
        if(this.rezervacijaVozila.mestoPreuzimanja === "")
          return false;
        if(this.rezervacijaVozila.brojPutnika <= 0)
          return false;
        if(this.rezervacijaVozila.datumPreuzimanja > this.rezervacijaVozila.datumVracanja)
          return false;
    */
        return true;
    };
    PrikazSobaComponent.prototype.rezervisiVozilo = function (idVozila) {
        //alert(idVozila)
        /*let rezervacija = new RezervacijaVozila()
        if(this.proveriRezervaciju())
        {
          rezervacija.datumPreuzimanja = this.konvertujUDobroVreme(this.rezervacijaVozila.datumPreuzimanja.toString().substring(4,15));
          rezervacija.datumVracanja = this.konvertujUDobroVreme(this.rezervacijaVozila.datumVracanja.toString().substring(4,15));
          rezervacija.tipVozila = this.rezervacijaVozila.tipVozila.toString();
          rezervacija.mestoPreuzimanja = this.rezervacijaVozila.mestoPreuzimanja.toString();
          rezervacija.mestoVracanja = this.rezervacijaVozila.mestoVracanja.toString();
          rezervacija.brojPutnika = this.rezervacijaVozila.brojPutnika;
          rezervacija.vozilo.id = idVozila;
          rezervacija.minimalnaCena = this.minValue;
          rezervacija.maksimalnaCena = this.maxValue;
    
          let navigationExtras: NavigationExtras = {
            queryParams: {
                "datumPreuzimanja": rezervacija.datumPreuzimanja,
                "datumVracanja": rezervacija.datumVracanja,
                "brojPutnika" : rezervacija.brojPutnika,
                "mestoPreuzimanja" : rezervacija.mestoPreuzimanja,
                "mestoVracanja" : rezervacija.mestoVracanja,
                "idRezervacije" : this.idRezervacije,
                
            }
        };
            this.router.navigate(['/rentacarovi/' + idVozila + '/potvrdiRezervaciju'], navigationExtras);
    
        }
        else{
          alert("morate uneti datum preuzimanja i vracanja, datum preuzimanja mora biti pre datuma vracanja, mesto preuzimanja i broj putnika veci od 0");
        }*/
    };
    PrikazSobaComponent = __decorate([
        core_1.Component({
            selector: 'app-prikaz-soba',
            template: __webpack_require__("./src/app/component/hotel/prikaz-soba/prikaz-soba.component.html"),
            styles: [__webpack_require__("./src/app/component/hotel/prikaz-soba/prikaz-soba.component.css")]
        }),
        __metadata("design:paramtypes", [soba_service_1.SobaService, router_1.Router, router_1.ActivatedRoute,
            auth_service_1.AuthService])
    ], PrikazSobaComponent);
    return PrikazSobaComponent;
}());
exports.PrikazSobaComponent = PrikazSobaComponent;


/***/ }),

/***/ "./src/app/component/obavestenja/page-not-found/page-not-found.component.css":
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/component/obavestenja/page-not-found/page-not-found.component.html":
/***/ (function(module, exports) {

module.exports = "<p>\n  page-not-found works! RADI NESTO\n</p>\n"

/***/ }),

/***/ "./src/app/component/obavestenja/page-not-found/page-not-found.component.ts":
/***/ (function(module, exports, __webpack_require__) {

"use strict";

var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
Object.defineProperty(exports, "__esModule", { value: true });
var core_1 = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
var PageNotFoundComponent = /** @class */ (function () {
    function PageNotFoundComponent() {
    }
    PageNotFoundComponent.prototype.ngOnInit = function () {
    };
    PageNotFoundComponent = __decorate([
        core_1.Component({
            selector: 'app-page-not-found',
            template: __webpack_require__("./src/app/component/obavestenja/page-not-found/page-not-found.component.html"),
            styles: [__webpack_require__("./src/app/component/obavestenja/page-not-found/page-not-found.component.css")]
        }),
        __metadata("design:paramtypes", [])
    ], PageNotFoundComponent);
    return PageNotFoundComponent;
}());
exports.PageNotFoundComponent = PageNotFoundComponent;


/***/ }),

/***/ "./src/app/component/vozila/azuriranje-garaze/azuriranje-garaze.component.css":
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/component/vozila/azuriranje-garaze/azuriranje-garaze.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"container\" style=\"display: flex; justify-content: center;\">\n    <div class=\"col-md-5 form\">\n        <div class=\"form-area\">  \n            <form role=\"form\" #formFilijala=\"ngForm\">\n            <br style=\"clear:both\">\n                        <h3 style=\"margin-bottom: 25px; text-align: center;\">Azuriranje filijale</h3>\n                <div class=\"form-group\">\n                <label>Ime filijale</label>\n                <input type=\"text\"  [readonly] = true class=\"form-control\" minlength=\"3\" maxlength=\"30\" #ime=\"ngModel\" id=\"ime\" name=\"ime\" placeholder=\"Ime filijale\" required [(ngModel)] = \"filijala.kompanijaDTO.naziv\">\n                <small [hidden]=\"ime.valid || (ime.pristine && !formFilijala.submitted)\" class=\"text-danger\">\n                    Ime je obavezno (minimum 3 karaktera a maksimum 30 karaktera).\n                </small>\n              </div>\n              <div class=\"form-group\">\n                    <label>Zemlja</label>\n                  <input type=\"text\" class=\"form-control\" id=\"zemlja\" name=\"zemlja\" minlength=\"3\" maxlength=\"30\" #zemlja=\"ngModel\" placeholder=\"zemlja\" required [(ngModel)] = \"filijala.adresaDTO.zemlja\">\n                  <small [hidden]=\"zemlja.valid || (zemlja.pristine && !formFilijala.submitted)\" class=\"text-danger\">\n                    Zemlja je obavezna (minimum 3 karaktera a maksimum 30 karaktera).\n                  </small>\n                 </div>\n               <div class=\"form-group\">\n                    <label>Grad</label>\n                  <input type=\"text\" class=\"form-control\" id=\"grad\" name=\"grad\" minlength=\"3\" maxlength=\"30\" #grad=\"ngModel\" placeholder=\"grad\" required [(ngModel)] = \"filijala.adresaDTO.grad\">\n                  <small [hidden]=\"grad.valid || (grad.pristine && !formFilijala.submitted)\" class=\"text-danger\">\n                    Grad je obavezan (minimum 3 karaktera a maksimum 30 karaktera).\n                  </small>\n                </div>\n                <div class=\"form-group\">\n                    <label>Ulica</label>\n                  <input type=\"text\" class=\"form-control\" id=\"ulica\" name=\"ulica\" minlength=\"3\" maxlength=\"30\" #ulica=\"ngModel\" placeholder=\"ulica\" required [(ngModel)] = \"filijala.adresaDTO.ulica\">\n                  <small [hidden]=\"ulica.valid || (ulica.pristine && !formFilijala.submitted)\" class=\"text-danger\">\n                    Ulica je obavezna (minimum 3 karaktera a maksimum 30 karaktera).\n                  </small>\n                </div>\n                <div class=\"form-group\">\n                    <label>Broj</label>\n                  <input type=\"text\" class=\"form-control\" id=\"broj\" name=\"broj\" minlength=\"1\"  #broj=\"ngModel\" placeholder=\"broj\" required [(ngModel)] = \"filijala.adresaDTO.broj\">\n                  <small [hidden]=\"broj.valid || (broj.pristine && !formFilijala.submitted)\" class=\"text-danger\">\n                    Broj je obavezan (Veci od 0).\n                  </small>  \n                </div>\n              <button *ngIf=\"isDataAvailable\" type=\"button\" [disabled]=\"!formFilijala.valid\" id=\"submit\" name=\"submit\" class=\"btn btn-primary pull-right\" (click) = \"update()\">Azuriraj</button>\n              <button *ngIf=\"!isDataAvailable\" type=\"button\" [disabled]=\"!formFilijala.valid\" id=\"submit\" name=\"submit\" class=\"btn btn-primary pull-right\" (click) = \"save()\">Kreiraj</button>\n              \n              <button type=\"button\" id=\"submit\" name=\"submit\" class=\"btn btn-primary pull-right\" (click) = \"goBack()\">Odustani</button>\n            </form>\n        </div>\n    </div>\n    </div>"

/***/ }),

/***/ "./src/app/component/vozila/azuriranje-garaze/azuriranje-garaze.component.ts":
/***/ (function(module, exports, __webpack_require__) {

"use strict";

var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
Object.defineProperty(exports, "__esModule", { value: true });
var core_1 = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
var garaza_1 = __webpack_require__("./src/app/model/vozila/garaza.ts");
var garaza_service_1 = __webpack_require__("./src/app/service/vozila/garaza.service.ts");
var router_1 = __webpack_require__("./node_modules/@angular/router/esm5/router.js");
var kompanija_vozila_service_1 = __webpack_require__("./src/app/service/vozila/kompanija-vozila.service.ts");
var AzuriranjeGarazeComponent = /** @class */ (function () {
    function AzuriranjeGarazeComponent(filijalaService, kompanijaService, route, router) {
        this.filijalaService = filijalaService;
        this.kompanijaService = kompanijaService;
        this.route = route;
        this.router = router;
        this.filijala = new garaza_1.Garaza();
        this.maksimalnaDuzina = 30;
    }
    AzuriranjeGarazeComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.sub = this.route.params.subscribe(function (params) {
            _this.isDataAvailable = false;
            _this.kompanijaId = +params['kompanija-id'];
            if (params['garaza-id'] != null) {
                _this.id = +params['garaza-id']; // (+) konvertuje string 'id' u broj
                //id postavljamo kao path parametar pomocu interpolacije stringa
                if (_this.id != null) {
                    _this.filijalaService.findOne(_this.kompanijaId, _this.id).subscribe(function (e) {
                        _this.filijala = e;
                    });
                    _this.isDataAvailable = true;
                }
                else {
                    _this.isDataAvailable = false;
                    _this.filijala = new garaza_1.Garaza();
                }
            }
            else {
                _this.isDataAvailable = false;
                _this.filijala = new garaza_1.Garaza();
                _this.kompanijaService.findOne(_this.kompanijaId).subscribe(function (succ) {
                    _this.filijala.kompanijaDTO = succ;
                });
            }
        });
    };
    AzuriranjeGarazeComponent.prototype.save = function () {
        var _this = this;
        var message = this.proveriUnosFilijala();
        if (message === "OK") {
            this.filijalaService.addFilijala(this.filijala, this.kompanijaId).subscribe(function (s) {
                _this.filijala = s;
                _this.router.navigate(['kompanije-vozila/' + _this.kompanijaId + '/garaze']);
            }, function (err) { return console.log("err"); });
        }
        else {
            alert(message);
        }
    };
    AzuriranjeGarazeComponent.prototype.update = function () {
        var _this = this;
        var message = this.proveriUnosFilijala();
        if (message === "OK") {
            this.filijalaService.update(this.kompanijaId, this.filijala).subscribe(function (s) {
                _this.filijala = s;
                _this.router.navigate(['kompanije-vozila/' + _this.kompanijaId + '/garaze']);
            }, function (err) { return console.log("err"); });
        }
        else {
            alert(message);
        }
    };
    AzuriranjeGarazeComponent.prototype.goBack = function () {
        this.router.navigate(['kompanije-vozila/' + this.kompanijaId + '/garaze']);
    };
    AzuriranjeGarazeComponent.prototype.proveriUnosFilijala = function () {
        /*if(this.filijala.ime === "" || this.filijala.ime.length > this.maksimalnaDuzina){
          return "Morate popuniti ime filijale koje mora biti kraca od " + this.maksimalnaDuzina + " karaktera";
        }
    
        if(this.filijala.adresa === "" || this.filijala.adresa.length > this.maksimalnaDuzina){
          return "Morate popuniti adresu filijale koja mora biti kraca od " + this.maksimalnaDuzina + " karaktera";
        }*/
        return "OK";
    };
    AzuriranjeGarazeComponent = __decorate([
        core_1.Component({
            selector: 'app-azuriranje-garaze',
            template: __webpack_require__("./src/app/component/vozila/azuriranje-garaze/azuriranje-garaze.component.html"),
            styles: [__webpack_require__("./src/app/component/vozila/azuriranje-garaze/azuriranje-garaze.component.css")]
        }),
        __metadata("design:paramtypes", [garaza_service_1.GarazaService, kompanija_vozila_service_1.KompanijaVozilaService, router_1.ActivatedRoute, router_1.Router])
    ], AzuriranjeGarazeComponent);
    return AzuriranjeGarazeComponent;
}());
exports.AzuriranjeGarazeComponent = AzuriranjeGarazeComponent;


/***/ }),

/***/ "./src/app/component/vozila/azuriranje-kompanije-vozila/azuriranje-kompanije-vozila.component.css":
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/component/vozila/azuriranje-kompanije-vozila/azuriranje-kompanije-vozila.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"container\" style=\"display: flex; justify-content: center;\">\n  <div class=\"col-md-5 form\">\n      <div class=\"form-area\">  \n          <form role=\"form\" #formRent=\"ngForm\">\n          <br style=\"clear:both\">\n                      <h3 style=\"margin-bottom: 25px; text-align: center;\">Azuriranje Servisa</h3>\n            <div class=\"form-group\">\n                <input type=\"text\" class=\"form-control\" id=\"naziv\" minlength=\"3\" maxlength=\"30\" #naziv=\"ngModel\" name=\"naziv\" placeholder=\"Naziv rentacara\" required [(ngModel)] = \"rentacar.naziv\">\n                <small [hidden]=\"naziv.valid || (naziv.pristine && !formRent.submitted)\" class=\"text-danger\">\n                  Naziv je obavezan(minimum 3 karaktera a maksimum 30 karaktera).\n                </small>\n            </div>\n             <div class=\"form-group\">\n                <label>Zemlja</label>\n              <input type=\"text\" class=\"form-control\" id=\"zemlja\" name=\"zemlja\" minlength=\"3\" maxlength=\"30\" #zemlja=\"ngModel\" placeholder=\"zemlja\" required [(ngModel)] = \"rentacar.adresa.zemlja\">\n              <small [hidden]=\"zemlja.valid || (zemlja.pristine && !formRent.submitted)\" class=\"text-danger\">\n                Zemlja je obavezna (minimum 3 karaktera a maksimum 30 karaktera).\n              </small>\n            </div>\n            <div class=\"form-group\">\n                <label>Grad</label>\n              <input type=\"text\" class=\"form-control\" id=\"grad\" name=\"grad\" minlength=\"3\" maxlength=\"30\" #grad=\"ngModel\" placeholder=\"grad\" required [(ngModel)] = \"rentacar.adresa.grad\">\n              <small [hidden]=\"grad.valid || (grad.pristine && !formRent.submitted)\" class=\"text-danger\">\n                Grad je obavezan (minimum 3 karaktera a maksimum 30 karaktera).\n              </small>\n            </div>\n            <div class=\"form-group\">\n                <label>Ulica</label>\n              <input type=\"text\" class=\"form-control\" id=\"ulica\" name=\"ulica\" minlength=\"3\" maxlength=\"30\" #ulica=\"ngModel\" placeholder=\"ulica\" required [(ngModel)] = \"rentacar.adresa.ulica\">\n              <small [hidden]=\"ulica.valid || (ulica.pristine && !formRent.submitted)\" class=\"text-danger\">\n                Ulica je obavezna (minimum 3 karaktera a maksimum 30 karaktera).\n              </small>\n            </div>\n            <div class=\"form-group\">\n                <label>Broj</label>\n              <input type=\"text\" class=\"form-control\" id=\"broj\" name=\"broj\" minlength=\"1\"  #broj=\"ngModel\" placeholder=\"broj\" required [(ngModel)] = \"rentacar.adresa.broj\">\n              <small [hidden]=\"broj.valid || (broj.pristine && !formRent.submitted)\" class=\"text-danger\">\n                Broj je obavezan (Veci od 0).\n              </small> \n            </div>\n            <div class=\"form-group\">\n              <label>Geografska duzina</label>\n            <input type=\"text\" class=\"form-control\" minlength=\"1\" maxlength=\"30\" id=\"duzina\" name=\"duzina\" #duzina = \"ngModel\" placeholder=\"Geografska duzina\" required [(ngModel)] = \"rentacar.longitude\">\n            <small [hidden]=\"duzina.valid || (duzina.pristine && !formRent.submitted)\" class=\"text-danger\">\n              Geografska duzina je obavezna (minimum 1 karaktera a maksimum 30 karaktera).\n            </small>\n            </div>\n            <div class=\"form-group\">\n                <label>Geografska sirina</label>\n              <input type=\"text\" class=\"form-control\" maxlength=\"30\" id=\"sirina\" name=\"sirina\" #sirina = \"ngModel\" placeholder=\"Geografska sirina\" required [(ngModel)] = \"rentacar.latitude\">\n              <small [hidden]=\"sirina.valid || (sirina.pristine && !formRent.submitted)\" class=\"text-danger\">\n                Geografska sirina je obavezna (minimum 1 karaktera a maksimum 30 karaktera).\n              </small>\n            </div>\n            <div class=\"form-group\">\n              <textarea [(ngModel)] = \"rentacar.opis\" maxlength=\"140\" #opis=\"ngModel\" [ngModelOptions]=\"{standalone: true}\" class=\"form-control\" type=\"textarea\" id=\"promotivniOpis\" placeholder=\"Promotivni opis\" maxlength=\"140\" rows=\"7\" style=\"max-width: 100%; min-width: 100%;\" ></textarea>\n              <span class=\"help-block\"><p id=\"characterLeft\" class=\"help-block \">Maksimum 140 karaktera</p></span>                    \n              <small [hidden]=\"opis.valid || (opis.pristine && !formRent.submitted)\" class=\"text-danger\">\n                Promotivni opis je obavezan (minimum 3 karaktera a maksimum 140 karaktera).\n              </small>\n            </div>\n              \n          <button *ngIf=\"isDataAvailable\" type=\"button\" [disabled]=\"!formRent.valid\" id=\"submit\" style=\"margin:5px;\" name=\"submit\" class=\"btn btn-primary pull-right\" (click) = \"update()\">Azuriraj</button>\n          <button *ngIf=\"!isDataAvailable\" type=\"button\" [disabled]=\"!formRent.valid\" id=\"submit\" style=\"margin:5px;\" name=\"submit\" class=\"btn btn-primary pull-right\" (click) = \"save()\">Kreiraj</button>\n          <button type=\"button\" id=\"submit\" name=\"submit\" style=\"margin:5px;\" class=\"btn btn-primary pull-right\" (click) = \"goBack()\">Odustani</button>\n          </form>\n      </div>\n  </div>\n  </div>"

/***/ }),

/***/ "./src/app/component/vozila/azuriranje-kompanije-vozila/azuriranje-kompanije-vozila.component.ts":
/***/ (function(module, exports, __webpack_require__) {

"use strict";

var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
Object.defineProperty(exports, "__esModule", { value: true });
var core_1 = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
var router_1 = __webpack_require__("./node_modules/@angular/router/esm5/router.js");
var kompanijaVozila_1 = __webpack_require__("./src/app/model/vozila/kompanijaVozila.ts");
var kompanija_vozila_service_1 = __webpack_require__("./src/app/service/vozila/kompanija-vozila.service.ts");
var AzuriranjeKompanijeVozilaComponent = /** @class */ (function () {
    function AzuriranjeKompanijeVozilaComponent(rentacarService, route, router) {
        this.rentacarService = rentacarService;
        this.route = route;
        this.router = router;
        this.rentacar = new kompanijaVozila_1.KompanijaVozila();
        this.maksimalnaDuzina = 30;
        this.maksimalnaDuzinaOpis = 140;
    }
    AzuriranjeKompanijeVozilaComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.sub = this.route.params.subscribe(function (params) {
            _this.isDataAvailable = false;
            if (params['id'] != null) {
                _this.id = +params['id']; // (+) konvertuje string 'id' u broj
                //id postavljamo kao path parametar pomocu interpolacije stringa
                if (_this.id != null) {
                    _this.rentacarService.findOne(_this.id).subscribe(function (e) {
                        _this.rentacar = e;
                    });
                    _this.isDataAvailable = true;
                }
                else {
                    //znaci dodajem novi koji ne postoji
                    _this.rentacar = new kompanijaVozila_1.KompanijaVozila();
                    _this.isDataAvailable = false;
                }
            }
        });
    };
    AzuriranjeKompanijeVozilaComponent.prototype.save = function () {
        var _this = this;
        var message = this.proveriUnosRentacar();
        if (message === "OK") {
            this.rentacarService.addRentACar(this.rentacar).subscribe(function (s) {
                _this.rentacar = s;
                _this.router.navigate(['kompanije-vozila']);
            }, function (err) { return console.log("err"); });
        }
        else {
            alert(message);
        }
    };
    AzuriranjeKompanijeVozilaComponent.prototype.update = function () {
        var _this = this;
        var message = this.proveriUnosRentacar();
        if (message === "OK") {
            this.rentacarService.updateRentACar(this.rentacar.id, this.rentacar).subscribe(function (s) {
                _this.rentacar = s;
                _this.router.navigate(['kompanije-vozila']);
            }, function (err) { return console.log("err"); });
        }
        else {
            alert(message);
        }
    };
    AzuriranjeKompanijeVozilaComponent.prototype.goBack = function () {
        this.router.navigate(['kompanije-vozila']);
    };
    AzuriranjeKompanijeVozilaComponent.prototype.proveriUnosRentacar = function () {
        if (this.rentacar.naziv === "" || this.rentacar.naziv.length > this.maksimalnaDuzina) {
            return "Morate popuniti naziv rent-a koja mora biti kraci od " + this.maksimalnaDuzina + " karaktera";
        }
        /*if(this.rentacar.adresa === "" ||this.rentacar.adresa.length > this.maksimalnaDuzina){
          return "Morate popuniti adresu rent-a koja mora biti kraca od " + this.maksimalnaDuzina + " karaktera";
        }*/
        if (this.rentacar.opis === "" || this.rentacar.opis.length > this.maksimalnaDuzinaOpis) {
            return "Morate popuniti opis rent-a koji mora biti kraca od " + this.maksimalnaDuzinaOpis + " karaktera";
        }
        if (isNaN(this.rentacar.latitude) || isNaN(this.rentacar.longitude)) {
            return "Geografska sirina i duzina moraju biti brojevi";
        }
        return "OK";
    };
    AzuriranjeKompanijeVozilaComponent = __decorate([
        core_1.Component({
            selector: 'app-azuriranje-kompanije-vozila',
            template: __webpack_require__("./src/app/component/vozila/azuriranje-kompanije-vozila/azuriranje-kompanije-vozila.component.html"),
            styles: [__webpack_require__("./src/app/component/vozila/azuriranje-kompanije-vozila/azuriranje-kompanije-vozila.component.css")]
        }),
        __metadata("design:paramtypes", [kompanija_vozila_service_1.KompanijaVozilaService, router_1.ActivatedRoute, router_1.Router])
    ], AzuriranjeKompanijeVozilaComponent);
    return AzuriranjeKompanijeVozilaComponent;
}());
exports.AzuriranjeKompanijeVozilaComponent = AzuriranjeKompanijeVozilaComponent;


/***/ }),

/***/ "./src/app/component/vozila/azuriranje-vozila/azuriranje-vozila.component.css":
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/component/vozila/azuriranje-vozila/azuriranje-vozila.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"container\" style=\"display: flex; justify-content: center;\">\n    <div class=\"col-md-5 form\">\n        <div class=\"form-area\">  \n            <form role=\"form\"  #formVozilo=\"ngForm\">\n            <br style=\"clear:both\">\n                        <h3 style=\"margin-bottom: 25px; text-align: center;\">Azuriranje/Dodavanje vozila</h3>\n                <div class=\"form-group\">\n                <label>Marka vozila</label>\n                <input type=\"text\" class=\"form-control\" minlength=\"3\"  maxlength=\"30\" #marka=\"ngModel\" id=\"marka\" name=\"marka\" placeholder=\"Marka vozila\" required [(ngModel)] = \"vozilo.marka\">\n                <small [hidden]=\"marka.valid || (marka.pristine && !formVozilo.submitted)\" class=\"text-danger\">\n                  Marka je obavezna (minimum 3 karaktera a maksimum 30 karaktera).\n                </small>\n              </div>\n              <div class=\"form-group\">\n                <label>Model vozila</label>\n                <input type=\"text\" class=\"form-control\" minlength=\"3\"  maxlength=\"30\" #model=\"ngModel\" id=\"model\" name=\"model\" placeholder=\"Model vozila\" required [(ngModel)] = \"vozilo.model\">\n                <small [hidden]=\"model.valid || (model.pristine && !formVozilo.submitted)\" class=\"text-danger\">\n                  Model je obavezan (minimum 3 karaktera a maksimum 30 karaktera).\n                </small>\n              </div>\n              <div class=\"form-group\">\n                  <label>Naziv vozila</label>\n                  <input type=\"text\" class=\"form-control\" minlength=\"3\"  maxlength=\"30\" #naziv=\"ngModel\" id=\"model\" name=\"model\" placeholder=\"Naziv vozila\" required [(ngModel)] = \"vozilo.naziv\">\n                  <small [hidden]=\"naziv.valid || (naziv.pristine && !formVozilo.submitted)\" class=\"text-danger\">\n                    Naziv je obavezan (minimum 3 karaktera a maksimum 30 karaktera).\n                  </small>\n              </div>\n              <div class=\"form-group\">\n                <label>Tip vozila</label>\n                <input type=\"text\" class=\"form-control\"  minlength=\"3\"  maxlength=\"30\" #tip=\"ngModel\" id=\"tip\" name=\"tip\" placeholder=\"Tip vozila\" required [(ngModel)] = \"vozilo.tip\">\n                <small [hidden]=\"tip.valid || (tip.pristine && !formVozilo.submitted)\" class=\"text-danger\">\n                  Tip je obavezan (minimum 3 karaktera a maksimum 30 karaktera).\n                </small>\n              </div>\n              <div class=\"form-group\">\n                  <label>Cena vozila</label>\n                  <input type=\"text\" class=\"form-control\"  #cena=\"ngModel\" id=\"cena\" name=\"cena\" placeholder=\"Cena po danu vozila\" required [(ngModel)] = \"vozilo.cenaPoDanu\">\n                  <small [hidden]=\"cena.valid || (cena.pristine && !formVozilo.submitted)\" class=\"text-danger\">\n                    Cena po danu je obavezna (pozitivan broj).\n                  </small>\n                </div>\n              <div class=\"form-group\">\n                <label>Godina prozivodnje vozila</label>\n                <input type=\"text\" class=\"form-control\" #godina=\"ngModel\" id=\"godinaProizvodnje\" name=\"godinaProizvodnje\" placeholder=\"Godina proizvodnje vozila\" required [(ngModel)] = \"vozilo.godinaProizvodnje\">\n                <small [hidden]=\"godina.valid || (godina.pristine && !formVozilo.submitted)\" class=\"text-danger\">\n                  Godina je obavezna (pozitivan broj).\n                </small>\n              </div>\n              <div class=\"form-group\">\n                <label>Broj putnika vozila</label>\n                <input type=\"text\" #brojSedista=\"ngModel\" class=\"form-control\" id=\"sediste\" name=\"sediste\" placeholder=\"Broj sedista vozila\" required [(ngModel)] = \"vozilo.brojPutnika\">\n                <small [hidden]=\"brojSedista.valid || (brojSedista.pristine && !formVozilo.submitted)\" class=\"text-danger\">\n                  Broj putnika je obavezan (pozitivan broj).\n                </small>\n              </div>\n               \n              <div *ngIf=\"isDataAvailable\">\n                <button type=\"button\" [disabled]=\"!formVozilo.valid\" id=\"submit\" name=\"submit\" class=\"btn btn-primary pull-right\" style=\"margin:5px;\" (click) = \"update()\">Azuriraj</button>\n              </div>\n              <div *ngIf=\"!isDataAvailable\">\n                <button type=\"button\" [disabled]=\"!formVozilo.valid\" id=\"submit\" name=\"submit\" class=\"btn btn-primary pull-right\" style=\"margin:5px;\" (click) = \"create()\">Dodaj</button>\n              </div>\n              <button type=\"button\" id=\"submit\" name=\"submit\" class=\"btn btn-primary pull-right\" style=\"margin:5px;\" (click) = \"goBack()\">Odustani</button>\n            </form>\n        </div>\n    </div>\n    </div>"

/***/ }),

/***/ "./src/app/component/vozila/azuriranje-vozila/azuriranje-vozila.component.ts":
/***/ (function(module, exports, __webpack_require__) {

"use strict";

var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
Object.defineProperty(exports, "__esModule", { value: true });
var core_1 = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
var vozilo_1 = __webpack_require__("./src/app/model/vozila/vozilo.ts");
var router_1 = __webpack_require__("./node_modules/@angular/router/esm5/router.js");
var vozilo_service_1 = __webpack_require__("./src/app/service/vozila/vozilo.service.ts");
var AzuriranjeVozilaComponent = /** @class */ (function () {
    function AzuriranjeVozilaComponent(voziloService, route, router) {
        this.voziloService = voziloService;
        this.route = route;
        this.router = router;
        this.vozilo = new vozilo_1.Vozilo();
        this.maksimalnaDuzina = 30;
    }
    AzuriranjeVozilaComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.sub = this.route.params.subscribe(function (params) {
            _this.isDataAvailable = false;
            _this.idKompanija = +params['kompanija-id'];
            _this.idGaraze = +params['garaza-id'];
            if (params['id'] != null) {
                _this.id = +params['id']; // (+) konvertuje string 'id' u broj
                //id postavljamo kao path parametar pomocu interpolacije stringa  
                if (_this.id != null) {
                    _this.voziloService.findOne(_this.idKompanija, _this.idGaraze, _this.id).subscribe(function (e) {
                        _this.vozilo = e;
                    });
                    _this.isDataAvailable = true;
                }
                else {
                    //znaci dodajem novi koji ne postoji
                    _this.vozilo = new vozilo_1.Vozilo();
                    _this.isDataAvailable = false;
                }
            }
        });
    };
    AzuriranjeVozilaComponent.prototype.create = function () {
        var _this = this;
        var message = this.proveriUnosVozilo();
        if (message === "OK") {
            this.voziloService.addVozilo(this.idKompanija, this.idGaraze, this.vozilo).subscribe(function (s) {
                _this.vozilo = s;
                _this.router.navigate(['kompanije-vozila/' + _this.idKompanija + '/garaze/' + _this.idGaraze + '/vozila']);
            }, function (err) { return console.log("err"); });
        }
        else {
            alert(message);
        }
    };
    AzuriranjeVozilaComponent.prototype.update = function () {
        var _this = this;
        var message = this.proveriUnosVozilo();
        if (message === "OK") {
            this.voziloService.updateVozilo(this.idKompanija, this.idGaraze, this.vozilo.id, this.vozilo).subscribe(function (s) {
                _this.vozilo = s;
                _this.router.navigate(['kompanije-vozila/' + _this.idKompanija + '/garaze/' + _this.idGaraze + '/vozila']);
            }, function (err) {
                console.log("err");
                if (err.status === 418) {
                    alert("Nije moguce izmeniti zeljeno vozilo vec je izmenjeno od strane drugog admina rent a car servisa.");
                }
            });
        }
        else {
            alert(message);
        }
    };
    AzuriranjeVozilaComponent.prototype.goBack = function () {
        this.router.navigate(['kompanije-vozila/' + this.idKompanija + '/garaze/' + this.idGaraze + '/vozila']);
    };
    AzuriranjeVozilaComponent.prototype.proveriUnosVozilo = function () {
        if (this.vozilo.marka === "" || this.vozilo.marka.length > this.maksimalnaDuzina) {
            return "Morate popuniti marku vozila koja mora biti kraca od " + this.maksimalnaDuzina + " karaktera";
        }
        if (this.vozilo.model === "" || this.vozilo.model.length > this.maksimalnaDuzina) {
            return "Morate popuniti model vozila koja mora biti kraca od " + this.maksimalnaDuzina + " karaktera";
        }
        if (this.vozilo.naziv === "" || this.vozilo.naziv.length > this.maksimalnaDuzina) {
            return "Morate popuniti naziv vozila koja mora biti kraca od " + this.maksimalnaDuzina + " karaktera";
        }
        if (this.vozilo.tip === "" || this.vozilo.tip.length > this.maksimalnaDuzina) {
            return "Morate popuniti tip vozila koja mora biti kraca od " + this.maksimalnaDuzina + " karaktera";
        }
        if (this.vozilo.cenaPoDanu <= 0) {
            return "Morate popuniti cenu vozila po danu koja mora biti pozitivan broj";
        }
        if (this.vozilo.godinaProizvodnje <= 0) {
            return "Morate popuniti godinu proizvodnje vozila koja mora biti pozitivan broj";
        }
        if (this.vozilo.brojPutnika <= 0) {
            return "Morate popuniti broj putnika vozila koja mora biti pozitivan broj";
        }
        return "OK";
    };
    AzuriranjeVozilaComponent = __decorate([
        core_1.Component({
            selector: 'app-azuriranje-vozila',
            template: __webpack_require__("./src/app/component/vozila/azuriranje-vozila/azuriranje-vozila.component.html"),
            styles: [__webpack_require__("./src/app/component/vozila/azuriranje-vozila/azuriranje-vozila.component.css")]
        }),
        __metadata("design:paramtypes", [vozilo_service_1.VoziloService, router_1.ActivatedRoute, router_1.Router])
    ], AzuriranjeVozilaComponent);
    return AzuriranjeVozilaComponent;
}());
exports.AzuriranjeVozilaComponent = AzuriranjeVozilaComponent;


/***/ }),

/***/ "./src/app/component/vozila/prikaz-garaza/prikaz-garaza.component.css":
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/component/vozila/prikaz-garaza/prikaz-garaza.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"row\">\n\n    <div class=\"col-md-8 col-sm-offset-2\">\n      </div>\n    <div class=\"col-md-8 col-sm-offset-2\">\n          <div class=\"list-group\">\n            <a class=\"list-group-item\" style=\"min-height: 220px; max-height: 350px;\" *ngFor = \"let i = index; let garaza of garaze | paginate: { itemsPerPage: 5, currentPage: p }\">\n                  <div class=\"media col-md-3\">\n                      <figure class=\"pull-left\">\n                          <img class=\"media-object img-rounded img-responsive\"  src=\"assets/garaza.jpg\" alt=\"placehold.it/350x250\" >\n                      </figure>\n                  </div>\n                  <div class=\"col-md-6\">\n                      <h4 class=\"list-group-item-text\">Kompanija: {{garaza.kompanijaDTO.naziv}}</h4>\n                      <h4 class=\"list-group-item-text\">Zemlja: {{garaza.adresaDTO.zemlja}}</h4>\n                      <h4 class=\"list-group-item-text\">Grad: {{garaza.adresaDTO.grad}}</h4>\n                      <h4 class=\"list-group-item-text\">Ulica: {{garaza.adresaDTO.ulica}}</h4>\n                      <h4 class=\"list-group-item-text\">Broj: {{garaza.adresaDTO.broj}}</h4>\n                  </div>\n                  <div class=\"col-md-3 text-center centered-button\" style=\"vertical-align: middle;\">\n                      <button *ngIf=\"obrisiVoziloVidljivo(vozilo)\" type=\"button\" class=\"btn btn-default btn-lg btn-block\" (click) = \"delete(garaza.id)\">Obrisi</button>\n                      <button *ngIf=\"azurirajVoziloVidljivo(vozilo)\" type=\"button\" class=\"btn btn-default btn-lg btn-block\" (click) = \"update(garaza.id)\">Izmeni</button>\n                      <button type=\"button\" class=\"btn btn-default btn-lg btn-block\" (click) = \"viewDetails(garaza.id)\">Prikazi vozila</button>\n                      <button type=\"button\" class=\"btn btn-default btn-lg btn-block\" (click) = \"addVozilo(garaza.id)\">Kreiraj vozilo</button>\n                  </div>\n            </a>\n          </div>\n      <div class=\"item col-lg-10 col-lg-10\" style=\"width: 100%; text-align: center;\">\n          <pagination-controls (pageChange)=\"p = $event\"></pagination-controls>\n      </div>\n    </div>\n  </div>"

/***/ }),

/***/ "./src/app/component/vozila/prikaz-garaza/prikaz-garaza.component.ts":
/***/ (function(module, exports, __webpack_require__) {

"use strict";

var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
Object.defineProperty(exports, "__esModule", { value: true });
var core_1 = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
var garaza_service_1 = __webpack_require__("./src/app/service/vozila/garaza.service.ts");
var auth_service_1 = __webpack_require__("./src/app/auth.service.ts");
var router_1 = __webpack_require__("./node_modules/@angular/router/esm5/router.js");
var PrikazGarazaComponent = /** @class */ (function () {
    function PrikazGarazaComponent(filijalaService, router, route, authService) {
        this.filijalaService = filijalaService;
        this.router = router;
        this.route = route;
        this.authService = authService;
        this.garaze = [];
        this.dropdownSettings = {};
        this.min = new Date();
        this.idRezervacije = 0;
        var res = localStorage.getItem('token');
        if (res != null) {
            //this.tipkorisnika = this.authService.getRoles(res);
        }
        else {
            this.tipkorisnika = "nema_korisnika";
        }
    }
    PrikazGarazaComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.sub = this.route.params.subscribe(function (params) {
            _this.isDataAvailable = false;
            if (params['kompanija-id'] != null) {
                _this.id = +params['kompanija-id']; // (+) konvertuje string 'id' u broj
                //id postavljamo kao path parametar pomocu interpolacije stringa
                if (_this.id != null) {
                    /*this.voziloService.findVozilaForRent(this.id).subscribe(
                      e =>
                      {
                        this.vozila = e;
                      }
                    )*/
                    _this.getAll();
                }
            }
        });
    };
    PrikazGarazaComponent.prototype.getAll = function () {
        var _this = this;
        this.filijalaService.findAll(this.id).subscribe(function (s) { _this.garaze = s; });
    };
    PrikazGarazaComponent.prototype.update = function (id) {
        this.router.navigate(['kompanije-vozila/' + this.id + '/garaze/add/' + id]);
    };
    PrikazGarazaComponent.prototype.delete = function (id) {
        var _this = this;
        this.filijalaService.delete(this.id, id).subscribe(function (s) { return _this.getAll(); }, function (err) { return console.log("err"); });
    };
    // addVoziloToRent( ){
    //   this.router.navigate(['rentacarovi/' + this.id +  '/svaVozilaKojaSeMoguDodati']);
    // }
    PrikazGarazaComponent.prototype.viewDetails = function (idGaraze) {
        this.router.navigate(['kompanije-vozila/' + this.id + '/garaze/' + idGaraze + '/vozila']);
    };
    PrikazGarazaComponent.prototype.addVozilo = function (idGaraze) {
        this.router.navigate(['kompanije-vozila/' + this.id + '/garaze/' + idGaraze + '/vozila/add']);
    };
    PrikazGarazaComponent.prototype.obrisiVoziloVidljivo = function (vozilo) {
        /*if(!vozilo.dozvoljenoBrisanjeIzmena){
          return false;
        }*/
        // if(this.tipkorisnika === "ROLE_Administrator_rent_a_car_servisa"){
        //   return true;
        // }
        // return false; 
        return true;
    };
    PrikazGarazaComponent.prototype.azurirajVoziloVidljivo = function (vozilo) {
        /*if(!vozilo.dozvoljenoBrisanjeIzmena){
          return false;
        }*/
        // if(this.tipkorisnika === "ROLE_Administrator_rent_a_car_servisa"){
        //   return true;
        // }
        // return false; 
        return true;
    };
    PrikazGarazaComponent = __decorate([
        core_1.Component({
            selector: 'app-prikaz-garaza',
            template: __webpack_require__("./src/app/component/vozila/prikaz-garaza/prikaz-garaza.component.html"),
            styles: [__webpack_require__("./src/app/component/vozila/prikaz-garaza/prikaz-garaza.component.css")]
        }),
        __metadata("design:paramtypes", [garaza_service_1.GarazaService, router_1.Router, router_1.ActivatedRoute,
            auth_service_1.AuthService])
    ], PrikazGarazaComponent);
    return PrikazGarazaComponent;
}());
exports.PrikazGarazaComponent = PrikazGarazaComponent;


/***/ }),

/***/ "./src/app/component/vozila/prikaz-kompanija-vozila/prikaz-kompanija-vozila.component.css":
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/component/vozila/prikaz-kompanija-vozila/prikaz-kompanija-vozila.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"row\">\n  <div *ngIf = \"vidjivoBrzeRezervacije()\" class=\"col-md-8 col-sm-offset-4 brzaRezervacija\">\n      <img style=\"max-width: 100%; height: 200px;\" class=\"img-fluid\" (click) = \"brzaRezervacija()\" src=\"assets/hotel/SALE.jpg\"/>\n  </div>\n<div class=\"col-md-8 col-sm-offset-2\" style=\"margin-bottom: 15px;\">\n      <form class=\"md-form mr-auto mb-4\">\n              <table class=\"table table-striped\">\n          <tbody>\n              <tr>\n                  <td>\n                      <label>Adresa servisa</label>\n                  <ng-multiselect-dropdown [placeholder]=\"'Adresa'\" [data]=\"adreseRenta\" [(ngModel)]=\"izabranaAdresa\" [settings]=\"dropdownSettings\" [ngModelOptions]=\"{standalone: true}\">\n                  </ng-multiselect-dropdown>\n              </td>\n              <td>\n                  <label>Naziv servisa</label>\n                  <ng-multiselect-dropdown [placeholder]=\"'Naziv'\" [data]=\"naziviRenta\" [(ngModel)]=\"izabraniNaziv\" [settings]=\"dropdownSettings\" [ngModelOptions]=\"{standalone: true}\">\n                  </ng-multiselect-dropdown>\n              </td>\n              <td>\n                      <input class=\"form-control mr-sm-2\" style=\"margin-top:24px;\" type=\"button\" value=\"Trazi\" aria-label=\"Search\" (click) = \"trazi()\">\n              </td>\n          </tr>\n  </table>\n    </form>\n</div>\n  <div class=\"col-md-8 col-sm-offset-2\">\n        <div class=\"list-group\">\n          <a class=\"list-group-item\" style=\"min-height: 220px; max-height: 350px;\" *ngFor = \"let i = index; let rentacar of rentacarovi | paginate: { itemsPerPage: 5, currentPage: p }\">\n                <div class=\"media col-md-3\">\n                    <figure class=\"pull-left\">\n                        <img class=\"media-object img-rounded img-responsive\"  src=\"assets/kompanija.jpg\" alt=\"placehold.it/350x250\" (click)=\"viewDetails(rentacar.id)\">\n                    </figure>\n                </div>\n                <div class=\"col-md-6\">\n                  <a (click)=\"getAllSort('naziv')\">{{rentacar.naziv}} </a>\n                  <a (click)=\"getAllSort('adresa')\"> <small><i>{{rentacar.adresa.zemlja}}</i></small> <small><i>{{rentacar.adresa.grad}}</i></small> \n                    <small><i>{{rentacar.adresa.ulica}}</i></small> <small><i>{{rentacar.adresa.broj}}</i></small></a>\n                  <span class=\"glyphicon glyphicon-map-marker\" (click) = \"pokaziMapu(rentacar.longitude, rentacar.latitude)\" ></span>\n                  <p class=\"group inner list-group-item-text\">\n                    {{rentacar.opis}}</p>\n                </div>\n                <div *ngIf=\"ulogovaniKorisnikImaDozvoluDaBrise()\" class=\"col-md-2\" style=\"margin-top: 5px; padding: 0px;\">\n                  <span class=\"glyphicon glyphicon-trash\" (click) = \"delete(rentacar.id)\"></span>\n              </div>\n              <div *ngIf=\"ulogovaniKorisnikImaDozvoluDaMenja()\" class=\"col-md-2\" style=\"margin-top: 5px; padding: 0px;\">\n                  <span class=\"glyphicon glyphicon-wrench\" (click) = \"update(rentacar.id)\"></span>\n              </div>\n              <button *ngIf=\"ulogovaniKorisnikImaDozvoluDaMenja()\" (click) = \"createGarage(rentacar.id)\" >Kreiraj Garazu\n              </button>\n          </a>\n        </div>\n        \n    <div class=\"item col-lg-10 col-lg-10\" style=\"width: 100%; text-align: center;\">\n        <pagination-controls (pageChange)=\"p = $event\"></pagination-controls>\n    </div>\n  </div>\n</div>"

/***/ }),

/***/ "./src/app/component/vozila/prikaz-kompanija-vozila/prikaz-kompanija-vozila.component.ts":
/***/ (function(module, exports, __webpack_require__) {

"use strict";

var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
Object.defineProperty(exports, "__esModule", { value: true });
var core_1 = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
var router_1 = __webpack_require__("./node_modules/@angular/router/esm5/router.js");
var auth_service_1 = __webpack_require__("./src/app/auth.service.ts");
var kompanija_vozila_service_1 = __webpack_require__("./src/app/service/vozila/kompanija-vozila.service.ts");
var PrikazKompanijaVozilaComponent = /** @class */ (function () {
    function PrikazKompanijaVozilaComponent(route, rentacarService, router, authService) {
        this.route = route;
        this.rentacarService = rentacarService;
        this.router = router;
        this.authService = authService;
        this.rentacarovi = [];
        this.adreseRenta = [];
        this.pomAdreseRenta = [];
        this.naziviRenta = [];
        this.dropdownSettings = {};
        this.izabranaAdresa = "";
        this.izabraniNaziv = "";
        this.paramDir = "ASC";
        this.idRezervacije = 0;
        this.idFilijala = 0;
        var res = localStorage.getItem('token');
        if (res != null) {
            //this.tipkorisnika = this.authService.getRoles(res);
        }
        else {
            this.tipkorisnika = "nema_korisnika";
        }
        this.getAll();
    }
    PrikazKompanijaVozilaComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.rentacarService.vratiSveAdrese().subscribe(function (s) {
            s.forEach(function (item) {
                var temp = item.zemlja + " " + item.grad + " " + item.ulica + " " + item.broj;
                _this.pomAdreseRenta.push(temp);
            });
            _this.adreseRenta = _this.pomAdreseRenta;
        });
        this.rentacarService.vratiSveNazive().subscribe(function (a) {
            _this.naziviRenta = a;
        });
        this.dropdownSettings = {
            singleSelection: true,
            // idField: 'id',
            //textField: 'adreseRenta',
            itemsShowLimit: 3,
            allowSearchFilter: true
        };
        /* this.route.queryParams.subscribe(params => {
           if(params["idRezervacije"] !== undefined){
             this.idRezervacije = params["idRezervacije"];
           }
         });*/
    };
    PrikazKompanijaVozilaComponent.prototype.getAll = function () {
        var _this = this;
        /*if(this.tipkorisnika !== "nema_korisnika"){
          this.rentacarService.vratiListuOcenjivihServisa().subscribe(
            a =>
            {
              this.ocenjiviRentovi = a;
              this.rentacarService.findAll().subscribe(
            
                s => {
                  this.rentacarovi = s;
                }
              );
            }
          );
        }*/
        //else{
        this.rentacarService.findAll().subscribe(function (s) {
            _this.rentacarovi = s;
        });
        // }
    };
    PrikazKompanijaVozilaComponent.prototype.delete = function (id) {
        var _this = this;
        this.rentacarService.deleteRentACar(id).subscribe(function (s) { return _this.getAll(); }, function (err) { return console.log("err"); });
    };
    PrikazKompanijaVozilaComponent.prototype.update = function (id) {
        this.router.navigate(['kompanije-vozila/add', id]);
    };
    PrikazKompanijaVozilaComponent.prototype.postaviFilijalu = function (id) {
        this.idFilijala = id;
    };
    PrikazKompanijaVozilaComponent.prototype.viewDetails = function (id) {
        //if(this.idFilijala != 0){
        this.router.navigate(['kompanije-vozila/' + id + '/garaze']);
        /*}
        else{
          alert('izaberi filjalu');
        }*/
    };
    PrikazKompanijaVozilaComponent.prototype.createGarage = function (id) {
        this.router.navigate(['kompanije-vozila/' + id + '/garaze/add']);
    };
    PrikazKompanijaVozilaComponent.prototype.imageClick = function (id) {
        /*if(this.idRezervacije !== 0){
          let navigationExtras: NavigationExtras = {
            queryParams: {
                "idRezervacije" : this.idRezervacije
            }
          };
          this.router.navigate(['rentacarovi/' +  id + '/prikazVozila'], navigationExtras);
        }
        else {
          this.router.navigate(['rentacarovi/' +  id + '/prikazVozila']);
        }*/
    };
    PrikazKompanijaVozilaComponent.prototype.spanClick = function (id) {
        //this.router.navigate(['rentacarovi/' +  id + '/prikazFilijala']);
    };
    PrikazKompanijaVozilaComponent.prototype.ulogovaniKorisnikImaDozvoluDaMenja = function () {
        /*if( this.tipkorisnika === "ROLE_Administrator_rent_a_car_servisa" || this.tipkorisnika === "ROLE_Administrator_sistema"){
          return true;
        }
        return false; */
        return true;
    };
    PrikazKompanijaVozilaComponent.prototype.ulogovaniKorisnikImaDozvoluDaBrise = function () {
        // if(this.tipkorisnika === "ROLE_Administrator_sistema"){
        //   return true;
        // }
        // return false; 
        return true;
    };
    PrikazKompanijaVozilaComponent.prototype.rezervisiDugme = function () {
        if (this.tipkorisnika === "ROLE_Registrovani_korisnik") {
            return true;
        }
        return false;
    };
    PrikazKompanijaVozilaComponent.prototype.ocenaVidljivo = function () {
        if (this.tipkorisnika === "ROLE_Registrovani_korisnik") {
            return true;
        }
        return false;
    };
    PrikazKompanijaVozilaComponent.prototype.trazi = function () {
        // this.rentacarService.trazenjeRentacarova(this.izabraniNaziv, this.izabranaAdresa).subscribe(
        //   s => {
        //     this.rentacarovi = s;
        //   },
        //   err=> console.log("err")
        // );    
    };
    PrikazKompanijaVozilaComponent.prototype.getAllSort = function (paramSort) {
        var _this = this;
        this.rentacarService.findAllSort(paramSort, this.paramDir).subscribe(function (ss) { _this.rentacarovi = ss; });
        if (this.paramDir === 'ASC') {
            this.paramDir = 'DESC';
        }
        else {
            this.paramDir = 'ASC';
        }
    };
    PrikazKompanijaVozilaComponent.prototype.brzaRezervacija = function () {
        var navigationExtras = {
            queryParams: {
                "idRezervacije": this.idRezervacije
            }
        };
        this.router.navigate(['rentacarovi/brzaRezervacijaVozila'], navigationExtras);
    };
    PrikazKompanijaVozilaComponent.prototype.daLiSmeDaOceni = function (id) {
        if (this.ocenjiviRentovi.indexOf(id) > -1) {
            return false;
        }
        else {
            return true;
        }
    };
    PrikazKompanijaVozilaComponent.prototype.oceniServis = function (rentacar) {
        /*if(rentacar.ulogovanogKorisnikaOcena > 0){
          let ocena: OcenaRenta = new OcenaRenta();
          ocena.rentACar = rentacar;
          ocena.ocenaRenta = rentacar.ulogovanogKorisnikaOcena;
          this.rentacarService.oceniServis(1, ocena).subscribe(
            ajde =>
            {
            }
          )
        }*/
    };
    PrikazKompanijaVozilaComponent.prototype.pokaziMapu = function (longitude, latitude) {
        //this.router.navigate(['prikaziMapu/' + longitude + "/" + latitude]);
    };
    PrikazKompanijaVozilaComponent.prototype.vidjivoBrzeRezervacije = function () {
        if (this.tipkorisnika === "ROLE_Registrovani_korisnik" && this.idRezervacije !== 0) {
            return true;
        }
        return false;
    };
    PrikazKompanijaVozilaComponent = __decorate([
        core_1.Component({
            selector: 'app-prikaz-kompanija-vozila',
            template: __webpack_require__("./src/app/component/vozila/prikaz-kompanija-vozila/prikaz-kompanija-vozila.component.html"),
            styles: [__webpack_require__("./src/app/component/vozila/prikaz-kompanija-vozila/prikaz-kompanija-vozila.component.css")]
        }),
        __metadata("design:paramtypes", [router_1.ActivatedRoute, kompanija_vozila_service_1.KompanijaVozilaService, router_1.Router, auth_service_1.AuthService])
    ], PrikazKompanijaVozilaComponent);
    return PrikazKompanijaVozilaComponent;
}());
exports.PrikazKompanijaVozilaComponent = PrikazKompanijaVozilaComponent;


/***/ }),

/***/ "./src/app/component/vozila/prikaz-vozila/prikaz-vozila.component.css":
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/component/vozila/prikaz-vozila/prikaz-vozila.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"row\">\n    <div class=\"col-md-8 col-sm-offset-2\">\n            <button *ngIf=\"dodajAdminaVidljivo()\" style=\"width: auto; float: right;\" class=\"form-control mr-sm-5\" (click) = \"dodajAdministratora()\">Dodaj administratora rent a car</button>\n        <button *ngIf=\"dodajVoziloVidljivo()\" style=\"width: auto; float: right;\" class=\"form-control mr-sm-5\" (click) = \"izvestajPoslovanja()\">Izvestaj o poslovanju</button>\n    </div>\n  <div class=\"col-md-8 col-sm-offset-2\">\n        <div class=\"list-group\">\n          <a class=\"list-group-item\" style=\"min-height: 220px; max-height: 350px;\" *ngFor = \"let i = index; let vozilo of vozila | paginate: { itemsPerPage: 10, currentPage: p }\">\n                <div class=\"media col-md-3\">\n                    <figure class=\"pull-left\">\n                        <img class=\"media-object img-rounded img-responsive\"  src=\"assets/vozilo.jpg\" alt=\"placehold.it/350x250\" >\n                    </figure>\n                </div>\n                <div class=\"col-md-6\">\n                    <h3 class=\"list-group-item-heading\"> {{vozilo.garazaDTO.kompanijaDTO.naziv}} </h3>\n                    <h4 class=\"list-group-item-text\">Tip vozila: {{vozilo.tip}}</h4>\n                    <h4 class=\"list-group-item-text\">Marka: {{vozilo.marka}}</h4>\n                    <h4 class=\"list-group-item-text\">Model: {{vozilo.model}}</h4>\n                    <h4 class=\"list-group-item-text\">Cena: {{vozilo.cenaPoDanu}}$</h4>\n                    <h4 class=\"list-group-item-text\">Ocena: {{vozilo.prosecnaOcena}} <small> / </small> 5 </h4>\n                </div>\n                <!-- <div class=\"col-md-3 text-center centered\">\n                    <button *ngIf=\"rezervisiDugme()\" type=\"button\" class=\"btn btn-default btn-lg btn-block\" (click)=\"rezervisiVozilo(vozilo.id)\"> Rezervisi </button>\n                </div> -->\n                <div class=\"col-md-3 text-center centered-button\" style=\"vertical-align: middle;\">\n                    <button *ngIf=\"obrisiVoziloVidljivo(vozilo)\" type=\"button\" class=\"btn btn-default btn-lg btn-block\" (click) = \"deleteVoziloFromRent(vozilo)\">Obrisi</button>\n                    <button *ngIf=\"azurirajVoziloVidljivo(vozilo)\" type=\"button\" class=\"btn btn-default btn-lg btn-block\" (click) = \"update(vozilo.id)\">Izmeni</button>\n                </div>\n          </a>\n        </div>\n\n  </div>\n  <div class=\"col-md-10 col-sm-offset-1\">\n        <ng5-slider [(value)]=\"minValue\" [(highValue)]=\"maxValue\" [options]=\"options\"></ng5-slider>\n        <form class=\"md-form mr-auto mb-4\">\n            <table class=\"table table-striped\">\n                <tbody>\n                    <tr>\n                        <td>\n                            <label> Datum preuzimanja </label>\n                            <input class=\"form-control mr-sm-2\" placeholder=\"Date:\" \n                                    [(ngModel)]=\"rezervacijaVozila.pocetniDatum\"\n                                    [min]=\"min\"\n                                    (change)=\"promenaDatuma()\"\n                                    [owlDateTimeTrigger]=\"dt1\" [owlDateTime]=\"dt1\"  [ngModelOptions]=\"{standalone: true}\">\n                            <owl-date-time [pickerType]=\"'calendar'\" #dt1></owl-date-time>\n                          </td>\n                        <td>\n                            <label> Datum vracanja </label>\n                            <input class=\"form-control mr-sm-2\" placeholder=\"Date:\" \n                                    [(ngModel)]=\"rezervacijaVozila.krajnjiDatum\"\n                                    [min]=\"min\"\n                                    [owlDateTimeTrigger]=\"dt2\" [owlDateTime]=\"dt2\" [ngModelOptions]=\"{standalone: true}\">\n                            <owl-date-time [pickerType]=\"'calendar'\" #dt2></owl-date-time>\n                        </td>\n                        <td>\n                            <label> Broj putnika </label>\n                            <input class=\"form-control mr-sm-2\" type=\"text\" placeholder=\"Broj putnika\" aria-label=\"Search\" [(ngModel)] = \"rezervacijaVozila.brojPutnika\" [ngModelOptions]=\"{standalone: true}\" >\n                        </td>\n  \n                        <td>\n                              <label>Mesto preuzimanja</label>\n                          <ng-multiselect-dropdown [placeholder]=\"'Mesto preuzimanja'\" [data]=\"mestaFilijala\" [(ngModel)]=\"rezervacijaVozila.mestoPreuzimanja\" [settings]=\"dropdownSettings\" [ngModelOptions]=\"{standalone: true}\">\n                          </ng-multiselect-dropdown>\n                      </td>\n                      <td>\n                              <label>Mesto vracanja</label>\n                          <ng-multiselect-dropdown [placeholder]=\"'Mesto vracanja'\" [data]=\"mestaFilijala\" [(ngModel)]=\"rezervacijaVozila.mestoVracanja\" [settings]=\"dropdownSettings\" [ngModelOptions]=\"{standalone: true}\">\n                          </ng-multiselect-dropdown>\n                      </td>\n                      <td>\n                          <label>Tip vozila</label>\n                          <ng-multiselect-dropdown [placeholder]=\"'Tip vozila'\" [data]=\"tipoviVozila\" [(ngModel)]=\"rezervacijaVozila.tipVozila\" [settings]=\"dropdownSettings\" [ngModelOptions]=\"{standalone: true}\">\n                          </ng-multiselect-dropdown>\n                      </td>\n  \n                        <td>\n                            <input class=\"form-control mr-sm-2\" style=\"margin-top: 24px;\" type=\"button\" value=\"Trazi\" aria-label=\"Search\" (click) = \"trazi()\">\n                        </td>\n                  </tr>\n                </tbody>\n            </table>\n        </form>\n    </div>\n\n    <div class=\"item col-lg-10 col-lg-10\" style=\"width: 100%; text-align: center;\">\n            <pagination-controls (pageChange)=\"p = $event\"></pagination-controls>\n        </div>\n</div>\n"

/***/ }),

/***/ "./src/app/component/vozila/prikaz-vozila/prikaz-vozila.component.ts":
/***/ (function(module, exports, __webpack_require__) {

"use strict";

var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
Object.defineProperty(exports, "__esModule", { value: true });
var core_1 = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
var router_1 = __webpack_require__("./node_modules/@angular/router/esm5/router.js");
var ng5_slider_1 = __webpack_require__("./node_modules/ng5-slider/esm5/ng5-slider.js");
var vozilo_service_1 = __webpack_require__("./src/app/service/vozila/vozilo.service.ts");
var auth_service_1 = __webpack_require__("./src/app/auth.service.ts");
var garaza_service_1 = __webpack_require__("./src/app/service/vozila/garaza.service.ts");
var zakupVozila_1 = __webpack_require__("./src/app/model/vozila/zakupVozila.ts");
var PrikazVozilaComponent = /** @class */ (function () {
    function PrikazVozilaComponent(voziloService, filijalaService, router, route, authService) {
        this.voziloService = voziloService;
        this.filijalaService = filijalaService;
        this.router = router;
        this.route = route;
        this.authService = authService;
        this.vozila = [];
        this.rezervacijaVozila = new zakupVozila_1.ZakupVozila();
        this.dropdownSettings = {};
        this.min = new Date();
        this.idRezervacije = 0;
        this.minValue = 100;
        this.maxValue = 400;
        this.options = {
            floor: this.minValue,
            ceil: this.maxValue,
            translate: function (value, label) {
                switch (label) {
                    case ng5_slider_1.LabelType.Low:
                        return '<b>Min price:</b> $' + value;
                    case ng5_slider_1.LabelType.High:
                        return '<b>Max price:</b> $' + value;
                    default:
                        return '$' + value;
                }
            }
        };
        var res = localStorage.getItem('token');
        if (res != null) {
            //this.tipkorisnika = this.authService.getRoles(res);
        }
        else {
            this.tipkorisnika = "nema_korisnika";
        }
    }
    PrikazVozilaComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.sub = this.route.params.subscribe(function (params) {
            _this.isDataAvailable = false;
            if (params['kompanija-id'] != null) {
                _this.id = +params['kompanija-id']; // (+) konvertuje string 'id' u broj
                //id postavljamo kao path parametar pomocu interpolacije stringa
                _this.garazaId = +params['garaza-id'];
                if (_this.id != null) {
                    _this.voziloService.findAll(_this.id, _this.garazaId).subscribe(function (e) {
                        _this.vozila = e;
                    });
                    /*this.voziloService.vratiSveTipove().subscribe(
                      s =>
                      {
                        this.tipoviVozila = s;
                      }
                    )
          
                    this.filijalaService.vratiFilijaleForRent(this.id).subscribe(
                      a =>
                      {
                        this.mestaFilijala = a;
                      }
                    )*/
                    _this.dropdownSettings = {
                        singleSelection: true,
                        // idField: 'id',
                        // textField: 'tipoviVozila',
                        itemsShowLimit: 3,
                        allowSearchFilter: true
                    };
                    /*this.voziloService.minimalnaCenaVozila().subscribe(
                      succ =>
                      {
                        this.minValue = succ;
          
                        this.voziloService.maksimalnaCenaVozila().subscribe(
                          success =>
                          {
                            this.maxValue = success;
              
                            this.options =  {
                              floor: this.minValue,
                              ceil: this.maxValue,
                              translate: (value: number, label: LabelType): string => {
                                switch (label) {
                                  case LabelType.Low:
                                    return '<b>Min price:</b> $' + value;
                                  case LabelType.High:
                                    return '<b>Max price:</b> $' + value;
                                  default:
                                    return '$' + value;
                                }
                              }
                            };
                          }
                        )
                      }
                    ) */
                }
            }
        });
        // this.route.queryParams.subscribe(params => {
        //   if(params["idRezervacije"] !== undefined){
        //     this.idRezervacije = params["idRezervacije"];
        //   }
        // });
    };
    PrikazVozilaComponent.prototype.getAll = function () {
        var _this = this;
        this.voziloService.findAll(this.id, this.garazaId).subscribe(function (s) { _this.vozila = s; });
    };
    PrikazVozilaComponent.prototype.deleteVoziloFromRent = function (vozilo) {
        var _this = this;
        this.voziloService.deleteVozilo(this.id, this.garazaId, vozilo.id).subscribe(function (s) {
            _this.ngOnInit();
            //this.router.navigate(['hoteli/' + soba.hotel.id + '/prikazSoba']);
        }, function (err) { return console.log("err"); });
    };
    PrikazVozilaComponent.prototype.update = function (id) {
        this.router.navigate(['kompanije-vozila/' + this.id + '/garaze/' + this.garazaId + '/vozila/add/' + id]);
    };
    PrikazVozilaComponent.prototype.addVozilo = function (id) {
        this.router.navigate(['kompanije-vozila/' + this.id + '/garaze/' + this.garazaId + '/vozila/add']);
    };
    // rezervisiDugme(){
    //   if(this.tipkorisnika === "ROLE_Registrovani_korisnik" && this.idRezervacije !==0){
    //     return true;
    //   }
    //   return false; 
    // }
    PrikazVozilaComponent.prototype.obrisiVoziloVidljivo = function (vozilo) {
        /*if(!vozilo.dozvoljenoBrisanjeIzmena){
          return false;
        }*/
        // if(this.tipkorisnika === "ROLE_Administrator_rent_a_car_servisa"){
        //   return true;
        // }
        // return false; 
        return true;
    };
    PrikazVozilaComponent.prototype.azurirajVoziloVidljivo = function (vozilo) {
        /*if(!vozilo.dozvoljenoBrisanjeIzmena){
          return false;
        }*/
        // if(this.tipkorisnika === "ROLE_Administrator_rent_a_car_servisa"){
        //   return true;
        // }
        // return false; 
        return true;
    };
    PrikazVozilaComponent.prototype.dodajVoziloVidljivo = function () {
        // if(this.tipkorisnika === "ROLE_Administrator_rent_a_car_servisa"){
        //   return true;
        // }
        // return false; 
        return true;
    };
    PrikazVozilaComponent.prototype.dodajAdminaVidljivo = function () {
        // if(this.tipkorisnika === "ROLE_Administrator_sistema"){
        //   return true;
        // }
        // return false; 
        return true;
    };
    PrikazVozilaComponent.prototype.ocenaVidljivo = function () {
        // if(this.tipkorisnika === "ROLE_Registrovani_korisnik"){
        //   return true;
        // }
        // return false; 
        return true;
    };
    PrikazVozilaComponent.prototype.vidljivoPretraga = function () {
        // if(this.tipkorisnika === "ROLE_Registrovani_korisnik" || this.tipkorisnika === "nema_korisnika"){
        //   return true;
        // }
        // return false; 
        return true;
    };
    PrikazVozilaComponent.prototype.trazi = function () {
        /*let rezervacija = new RezervacijaVozila()
        if(this.proveriRezervaciju())
        {
          rezervacija.datumPreuzimanja = this.konvertujUDobroVreme(this.rezervacijaVozila.datumPreuzimanja.toString().substring(4,15));
          rezervacija.datumVracanja = this.konvertujUDobroVreme(this.rezervacijaVozila.datumVracanja.toString().substring(4,15));
          rezervacija.tipVozila = this.rezervacijaVozila.tipVozila.toString();
          rezervacija.mestoPreuzimanja = this.rezervacijaVozila.mestoPreuzimanja.toString();
          rezervacija.mestoVracanja = this.rezervacijaVozila.mestoVracanja.toString();
          rezervacija.brojPutnika = this.rezervacijaVozila.brojPutnika;
          rezervacija.minimalnaCena = this.minValue;
          rezervacija.maksimalnaCena = this.maxValue;
          this.voziloService.traziVozilo(rezervacija, this.id).subscribe(
            s => {
              this.vozila = s;
            },
            err=> console.log("err")
          );
          }
          else{
            alert("morate uneti datum preuzimanja i vracanja, mesto preuzimanja i broj putnika veci od 0");
          }*/
    };
    PrikazVozilaComponent.prototype.konvertujUDobroVreme = function (primljeniString) {
        var pravoVreme;
        pravoVreme = primljeniString.substring(7, 11) + "/" + primljeniString.substring(0, 3) + "/" + primljeniString.substring(4, 6);
        pravoVreme = this.mesecPrebaciUbroj(pravoVreme);
        //alert(pravoVreme)
        return pravoVreme;
    };
    PrikazVozilaComponent.prototype.mesecPrebaciUbroj = function (primljeniString) {
        primljeniString = primljeniString.replace("Jan", "01");
        primljeniString = primljeniString.replace("Feb", "02");
        primljeniString = primljeniString.replace("Mar", "03");
        primljeniString = primljeniString.replace("Apr", "04");
        primljeniString = primljeniString.replace("May", "05");
        primljeniString = primljeniString.replace("Jun", "06");
        primljeniString = primljeniString.replace("Jul", "07");
        primljeniString = primljeniString.replace("Aug", "08");
        primljeniString = primljeniString.replace("Sep", "09");
        primljeniString = primljeniString.replace("Oct", "10");
        primljeniString = primljeniString.replace("Nov", "11");
        primljeniString = primljeniString.replace("Dec", "12");
        return primljeniString;
    };
    PrikazVozilaComponent.prototype.proveriRezervaciju = function () {
        /*if(this.rezervacijaVozila.datumPreuzimanja === "")
          return false;
        if(this.rezervacijaVozila.datumVracanja === "")
          return false;
        if(this.rezervacijaVozila.mestoPreuzimanja === "")
          return false;
        if(this.rezervacijaVozila.brojPutnika <= 0)
          return false;
        if(this.rezervacijaVozila.datumPreuzimanja > this.rezervacijaVozila.datumVracanja)
          return false;
    */
        return true;
    };
    PrikazVozilaComponent.prototype.rezervisiVozilo = function (idVozila) {
        //alert(idVozila)
        /*let rezervacija = new RezervacijaVozila()
        if(this.proveriRezervaciju())
        {
          rezervacija.datumPreuzimanja = this.konvertujUDobroVreme(this.rezervacijaVozila.datumPreuzimanja.toString().substring(4,15));
          rezervacija.datumVracanja = this.konvertujUDobroVreme(this.rezervacijaVozila.datumVracanja.toString().substring(4,15));
          rezervacija.tipVozila = this.rezervacijaVozila.tipVozila.toString();
          rezervacija.mestoPreuzimanja = this.rezervacijaVozila.mestoPreuzimanja.toString();
          rezervacija.mestoVracanja = this.rezervacijaVozila.mestoVracanja.toString();
          rezervacija.brojPutnika = this.rezervacijaVozila.brojPutnika;
          rezervacija.vozilo.id = idVozila;
          rezervacija.minimalnaCena = this.minValue;
          rezervacija.maksimalnaCena = this.maxValue;
    
          let navigationExtras: NavigationExtras = {
            queryParams: {
                "datumPreuzimanja": rezervacija.datumPreuzimanja,
                "datumVracanja": rezervacija.datumVracanja,
                "brojPutnika" : rezervacija.brojPutnika,
                "mestoPreuzimanja" : rezervacija.mestoPreuzimanja,
                "mestoVracanja" : rezervacija.mestoVracanja,
                "idRezervacije" : this.idRezervacije,
                
            }
        };
            this.router.navigate(['/rentacarovi/' + idVozila + '/potvrdiRezervaciju'], navigationExtras);
    
        }
        else{
          alert("morate uneti datum preuzimanja i vracanja, datum preuzimanja mora biti pre datuma vracanja, mesto preuzimanja i broj putnika veci od 0");
        }*/
    };
    PrikazVozilaComponent = __decorate([
        core_1.Component({
            selector: 'app-prikaz-vozila',
            template: __webpack_require__("./src/app/component/vozila/prikaz-vozila/prikaz-vozila.component.html"),
            styles: [__webpack_require__("./src/app/component/vozila/prikaz-vozila/prikaz-vozila.component.css")]
        }),
        __metadata("design:paramtypes", [vozilo_service_1.VoziloService, garaza_service_1.GarazaService, router_1.Router, router_1.ActivatedRoute,
            auth_service_1.AuthService])
    ], PrikazVozilaComponent);
    return PrikazVozilaComponent;
}());
exports.PrikazVozilaComponent = PrikazVozilaComponent;


/***/ }),

/***/ "./src/app/h-interceptor.service.ts":
/***/ (function(module, exports, __webpack_require__) {

"use strict";

var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
Object.defineProperty(exports, "__esModule", { value: true });
var core_1 = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
var HInterceptorService = /** @class */ (function () {
    function HInterceptorService(injector) {
        this.injector = injector;
    } //u svaki zahtev postavi header na aplication json
    HInterceptorService.prototype.intercept = function (request, next) {
        if (localStorage.getItem('token') != null) {
            request = request.clone({
                setHeaders: {
                    'Content-Type': 'application/json',
                    'Authorization': "Bearer " + localStorage.getItem('token')
                }
            });
        }
        else {
            request = request.clone({});
        }
        return next.handle(request);
    };
    HInterceptorService = __decorate([
        core_1.Injectable(),
        __metadata("design:paramtypes", [core_1.Injector])
    ], HInterceptorService);
    return HInterceptorService;
}());
exports.HInterceptorService = HInterceptorService;


/***/ }),

/***/ "./src/app/model/hotel/cenovnikSobe.ts":
/***/ (function(module, exports, __webpack_require__) {

"use strict";

Object.defineProperty(exports, "__esModule", { value: true });
var CenovnikSobe = /** @class */ (function () {
    function CenovnikSobe() {
        this.id = 0;
        this.pocetniDatum = "";
        this.krajnjiDatum = "";
        this.cena = 0;
    }
    return CenovnikSobe;
}());
exports.CenovnikSobe = CenovnikSobe;


/***/ }),

/***/ "./src/app/model/hotel/hotel.ts":
/***/ (function(module, exports, __webpack_require__) {

"use strict";

Object.defineProperty(exports, "__esModule", { value: true });
var adresa_1 = __webpack_require__("./src/app/model/opsti/adresa.ts");
var Hotel = /** @class */ (function () {
    function Hotel() {
        this.id = 0;
        this.naziv = "";
        this.opis = "";
        this.adresaDTO = new adresa_1.Adresa();
    }
    return Hotel;
}());
exports.Hotel = Hotel;


/***/ }),

/***/ "./src/app/model/hotel/opcija.ts":
/***/ (function(module, exports, __webpack_require__) {

"use strict";

Object.defineProperty(exports, "__esModule", { value: true });
var Opcija = /** @class */ (function () {
    function Opcija() {
        this.id = 0;
        this.naziv = "";
        this.cena = 0;
    }
    return Opcija;
}());
exports.Opcija = Opcija;


/***/ }),

/***/ "./src/app/model/hotel/soba.ts":
/***/ (function(module, exports, __webpack_require__) {

"use strict";

Object.defineProperty(exports, "__esModule", { value: true });
var Soba = /** @class */ (function () {
    function Soba() {
        this.id = 0;
        this.sprat = 0;
        this.brojKreveta = 0;
        this.tip = "";
        this.cenaPoDanu = 0;
        this.prosecnaOcena = 0;
    }
    return Soba;
}());
exports.Soba = Soba;


/***/ }),

/***/ "./src/app/model/hotel/zakupSoba.ts":
/***/ (function(module, exports, __webpack_require__) {

"use strict";

Object.defineProperty(exports, "__esModule", { value: true });
var ZakupSoba = /** @class */ (function () {
    function ZakupSoba() {
        this.id = 0;
        this.pocetniDatum = "";
        this.krajnjiDatum = "";
        this.cenaZakupa = 0;
        this.dodatniPopust = 0;
        this.popustNaTip = 0;
        this.tip = "";
        this.brojGostiju = 0;
        this.sobe = [];
        this.opcije = [];
        this.minimalnaCena = 0;
        this.maksimalnaCena = 0;
    }
    return ZakupSoba;
}());
exports.ZakupSoba = ZakupSoba;


/***/ }),

/***/ "./src/app/model/opsti/adresa.ts":
/***/ (function(module, exports, __webpack_require__) {

"use strict";

Object.defineProperty(exports, "__esModule", { value: true });
var Adresa = /** @class */ (function () {
    function Adresa() {
        this.id = 0;
        this.zemlja = "";
        this.grad = "";
        this.ulica = "";
        this.broj = 0;
    }
    return Adresa;
}());
exports.Adresa = Adresa;


/***/ }),

/***/ "./src/app/model/vozila/garaza.ts":
/***/ (function(module, exports, __webpack_require__) {

"use strict";

Object.defineProperty(exports, "__esModule", { value: true });
var kompanijaVozila_1 = __webpack_require__("./src/app/model/vozila/kompanijaVozila.ts");
var adresa_1 = __webpack_require__("./src/app/model/opsti/adresa.ts");
var Garaza = /** @class */ (function () {
    function Garaza() {
        this.id = 0;
        this.kompanijaDTO = new kompanijaVozila_1.KompanijaVozila();
        this.adresaDTO = new adresa_1.Adresa();
    }
    return Garaza;
}());
exports.Garaza = Garaza;


/***/ }),

/***/ "./src/app/model/vozila/kompanijaVozila.ts":
/***/ (function(module, exports, __webpack_require__) {

"use strict";

Object.defineProperty(exports, "__esModule", { value: true });
var adresa_1 = __webpack_require__("./src/app/model/opsti/adresa.ts");
var KompanijaVozila = /** @class */ (function () {
    function KompanijaVozila() {
        this.id = 0;
        this.naziv = "";
        this.opis = "";
        this.adresa = new adresa_1.Adresa();
        this.vozila = [];
        this.longitude = 0;
        this.latitude = 0;
    }
    return KompanijaVozila;
}());
exports.KompanijaVozila = KompanijaVozila;


/***/ }),

/***/ "./src/app/model/vozila/vozilo.ts":
/***/ (function(module, exports, __webpack_require__) {

"use strict";

Object.defineProperty(exports, "__esModule", { value: true });
var garaza_1 = __webpack_require__("./src/app/model/vozila/garaza.ts");
var Vozilo = /** @class */ (function () {
    function Vozilo() {
        this.id = 0;
        this.brojPutnika = 0;
        this.cenaPoDanu = 0;
        this.godinaProizvodnje = 0;
        this.marka = "";
        this.model = "";
        this.naziv = "";
        this.tip = "";
        this.garazaDTO = new garaza_1.Garaza();
    }
    return Vozilo;
}());
exports.Vozilo = Vozilo;


/***/ }),

/***/ "./src/app/model/vozila/zakupVozila.ts":
/***/ (function(module, exports, __webpack_require__) {

"use strict";

Object.defineProperty(exports, "__esModule", { value: true });
var vozilo_1 = __webpack_require__("./src/app/model/vozila/vozilo.ts");
var ZakupVozila = /** @class */ (function () {
    function ZakupVozila() {
        this.id = 0;
        this.pocetniDatum = "";
        this.krajnjiDatum = "";
        this.brojPutnika = 0;
        this.mestoPreuzimanja = "";
        this.mestoVracanja = "";
        this.cenaZakupa = 0;
        this.dodatniPopust = 0;
        this.popustNaTip = 0;
        this.tip = "";
        this.voziloDTO = new vozilo_1.Vozilo();
        this.maksimalnaCena = 0;
        this.minimalnaCena = 0;
    }
    return ZakupVozila;
}());
exports.ZakupVozila = ZakupVozila;


/***/ }),

/***/ "./src/app/service/hotel/cenovnik.service.ts":
/***/ (function(module, exports, __webpack_require__) {

"use strict";

var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
Object.defineProperty(exports, "__esModule", { value: true });
var core_1 = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
var http_1 = __webpack_require__("./node_modules/@angular/common/esm5/http.js");
var CenovnikService = /** @class */ (function () {
    function CenovnikService(http) {
        this.http = http;
    }
    CenovnikService.prototype.add = function (novaFilijala, idKompanije, sobaId) {
        return this.http.post("/hoteli/" + idKompanije + "/sobe/" + sobaId + "/cenovnici", novaFilijala);
    };
    CenovnikService.prototype.findOne = function (hotelId, id, sobaId) {
        return this.http.get("/hoteli/" + hotelId + "/sobe/" + sobaId + "/cenovnici/" + id);
    };
    CenovnikService.prototype.findAll = function (hotelId, sobaId) {
        return this.http.get("/hoteli/" + hotelId + "/sobe/" + sobaId + "/cenovnici");
    };
    CenovnikService.prototype.delete = function (hotelId, sobaId, id) {
        return this.http.delete("/hoteli/" + hotelId + "/sobe/" + sobaId + "/cenovnici/" + id);
    };
    CenovnikService.prototype.update = function (hotelId, sobaId, opcija) {
        return this.http.put("/hoteli/" + hotelId + "/sobe/" + sobaId + "/cenovnici", opcija);
    };
    CenovnikService = __decorate([
        core_1.Injectable(),
        __metadata("design:paramtypes", [http_1.HttpClient])
    ], CenovnikService);
    return CenovnikService;
}());
exports.CenovnikService = CenovnikService;


/***/ }),

/***/ "./src/app/service/hotel/hotel.service.ts":
/***/ (function(module, exports, __webpack_require__) {

"use strict";

var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
Object.defineProperty(exports, "__esModule", { value: true });
var core_1 = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
var http_1 = __webpack_require__("./node_modules/@angular/common/esm5/http.js");
var HotelService = /** @class */ (function () {
    function HotelService(http) {
        this.http = http;
    }
    HotelService.prototype.add = function (noviRentACar) {
        return this.http.post('/hoteli', noviRentACar);
    };
    HotelService.prototype.findOne = function (id) {
        return this.http.get("/hoteli/" + id);
    };
    HotelService.prototype.findAll = function () {
        return this.http.get('/hoteli');
    };
    HotelService.prototype.delete = function (id) {
        return this.http.delete("/hoteli/" + id);
    };
    HotelService.prototype.update = function (id, rentacar) {
        return this.http.put("/hoteli", rentacar);
    };
    HotelService.prototype.vratiSveNazive = function () {
        return this.http.get('/adrese'); //popraviti jos
    };
    HotelService.prototype.vratiSveAdrese = function () {
        return this.http.get('/adrese'); //popraviti jos
    };
    HotelService.prototype.trazenje = function (naziv, adresa) {
        var listaUslova = [];
        listaUslova.push(naziv.toString());
        listaUslova.push(adresa.toString());
        return this.http.post("/hoteli/trazenje", listaUslova);
    };
    HotelService.prototype.findAllSort = function (paramSort, paramDir) {
        return this.http.get("/hoteli?sort=" + paramSort + "," + paramDir);
    };
    HotelService = __decorate([
        core_1.Injectable(),
        __metadata("design:paramtypes", [http_1.HttpClient])
    ], HotelService);
    return HotelService;
}());
exports.HotelService = HotelService;


/***/ }),

/***/ "./src/app/service/hotel/opcija.service.ts":
/***/ (function(module, exports, __webpack_require__) {

"use strict";

var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
Object.defineProperty(exports, "__esModule", { value: true });
var core_1 = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
var http_1 = __webpack_require__("./node_modules/@angular/common/esm5/http.js");
var OpcijaService = /** @class */ (function () {
    function OpcijaService(http) {
        this.http = http;
    }
    OpcijaService.prototype.add = function (novaFilijala, idKompanije) {
        return this.http.post("/hoteli/" + idKompanije + "/opcije", novaFilijala);
    };
    OpcijaService.prototype.findOne = function (kompanijaId, id) {
        return this.http.get("/hoteli/" + kompanijaId + "/opcije/" + id);
    };
    OpcijaService.prototype.findAll = function (kompanijaId) {
        return this.http.get('/hoteli/' + kompanijaId + '/opcije');
    };
    OpcijaService.prototype.delete = function (kompanijaId, id) {
        return this.http.delete("/hoteli/" + kompanijaId + "/opcije/" + id);
    };
    OpcijaService.prototype.update = function (hotelId, opcija) {
        return this.http.put("/hoteli/" + hotelId + "/opcije", opcija);
    };
    OpcijaService = __decorate([
        core_1.Injectable(),
        __metadata("design:paramtypes", [http_1.HttpClient])
    ], OpcijaService);
    return OpcijaService;
}());
exports.OpcijaService = OpcijaService;


/***/ }),

/***/ "./src/app/service/hotel/soba.service.ts":
/***/ (function(module, exports, __webpack_require__) {

"use strict";

var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
Object.defineProperty(exports, "__esModule", { value: true });
var core_1 = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
var http_1 = __webpack_require__("./node_modules/@angular/common/esm5/http.js");
var SobaService = /** @class */ (function () {
    function SobaService(http) {
        this.http = http;
    }
    /*addToRent(id: number, idRent: number): Observable<Vozilo[]> {
      return this.http.get<Vozilo[]>(`/api/rentacarovi/${idRent}/dodajURentVozilo/${id}`);
    }*/
    SobaService.prototype.findOne = function (hotel, id) {
        return this.http.get("/hoteli/" + hotel + "/sobe/" + id);
    };
    SobaService.prototype.findAll = function (hotel) {
        return this.http.get("/hoteli/" + hotel + "/sobe");
    };
    /*findAllVozilaToAdd(): Observable<Vozilo[]> {
      return this.http.get<Vozilo[]>(`/api/rentacarovi/svaVozilaKojaSeMoguDodati`);
    }
  
    findVozilaForRent(id: number):Observable<Vozilo[]> {
      return this.http.get<Vozilo[]>(`/api/rentacarovi/${id}/prikazVozila`);
    }*/
    SobaService.prototype.delete = function (hotel, id) {
        return this.http.delete("/hoteli/" + hotel + "/sobe/" + id);
    };
    // deleteVoziloFromRent(id: number): Observable<{}> {
    //   return this.http.delete(`/api/vozila/${id}/deleteFromRent`);
    // }
    SobaService.prototype.update = function (hotel, id, vozilo) {
        return this.http.put("/hoteli/" + hotel + "/sobe", vozilo);
    };
    SobaService.prototype.add = function (hotel, vozilo) {
        return this.http.post("/hoteli/" + hotel + "/sobe", vozilo);
    };
    SobaService = __decorate([
        core_1.Injectable(),
        __metadata("design:paramtypes", [http_1.HttpClient])
    ], SobaService);
    return SobaService;
}());
exports.SobaService = SobaService;


/***/ }),

/***/ "./src/app/service/vozila/garaza.service.ts":
/***/ (function(module, exports, __webpack_require__) {

"use strict";

var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
Object.defineProperty(exports, "__esModule", { value: true });
var core_1 = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
var http_1 = __webpack_require__("./node_modules/@angular/common/esm5/http.js");
var GarazaService = /** @class */ (function () {
    function GarazaService(http) {
        this.http = http;
    }
    GarazaService.prototype.addFilijala = function (novaFilijala, idKompanije) {
        return this.http.post("/kompanije-vozila/" + idKompanije + "/garaze", novaFilijala);
    };
    /*addToRent(id: number, idRent: number): Observable<Garaza[]> {
      return this.http.get<Garaza[]>(`/api/rentacarovi/${idRent}/dodajURentFilijalu/${id}`);
    }*/
    GarazaService.prototype.findOne = function (kompanijaId, id) {
        return this.http.get("/kompanije-vozila/" + kompanijaId + "/garaze/" + id);
    };
    GarazaService.prototype.findAll = function (kompanijaId) {
        return this.http.get('/kompanije-vozila/' + kompanijaId + '/garaze');
    };
    GarazaService.prototype.delete = function (kompanijaId, id) {
        return this.http.delete("/kompanije-vozila/" + kompanijaId + "/garaze/" + id);
    };
    GarazaService.prototype.update = function (kompanijaId, filijala) {
        return this.http.put("/kompanije-vozila/" + kompanijaId + "/garaze", filijala);
    };
    GarazaService = __decorate([
        core_1.Injectable(),
        __metadata("design:paramtypes", [http_1.HttpClient])
    ], GarazaService);
    return GarazaService;
}());
exports.GarazaService = GarazaService;


/***/ }),

/***/ "./src/app/service/vozila/kompanija-vozila.service.ts":
/***/ (function(module, exports, __webpack_require__) {

"use strict";

var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
Object.defineProperty(exports, "__esModule", { value: true });
var core_1 = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
var http_1 = __webpack_require__("./node_modules/@angular/common/esm5/http.js");
var KompanijaVozilaService = /** @class */ (function () {
    function KompanijaVozilaService(http) {
        this.http = http;
    }
    KompanijaVozilaService.prototype.addRentACar = function (noviRentACar) {
        return this.http.post('/kompanije-vozila', noviRentACar);
    };
    KompanijaVozilaService.prototype.findOne = function (id) {
        return this.http.get("/kompanije-vozila/" + id);
    };
    KompanijaVozilaService.prototype.findAll = function () {
        return this.http.get('/kompanije-vozila');
    };
    KompanijaVozilaService.prototype.deleteRentACar = function (id) {
        return this.http.delete("/kompanije-vozila/" + id);
    };
    KompanijaVozilaService.prototype.updateRentACar = function (id, rentacar) {
        return this.http.put("/kompanije-vozila", rentacar);
    };
    KompanijaVozilaService.prototype.vratiSveNazive = function () {
        return this.http.get('/adrese'); //popraviti jos
    };
    KompanijaVozilaService.prototype.vratiSveAdrese = function () {
        return this.http.get('/adrese'); //popraviti jos
    };
    KompanijaVozilaService.prototype.trazenjeRentacarova = function (naziv, adresa) {
        var listaUslova = [];
        listaUslova.push(naziv.toString());
        listaUslova.push(adresa.toString());
        return this.http.post("/kompanije-vozila/trazenjeRentacarovi", listaUslova);
    };
    KompanijaVozilaService.prototype.findAllSort = function (paramSort, paramDir) {
        return this.http.get("/kompanije-vozila?sort=" + paramSort + "," + paramDir);
    };
    KompanijaVozilaService = __decorate([
        core_1.Injectable(),
        __metadata("design:paramtypes", [http_1.HttpClient])
    ], KompanijaVozilaService);
    return KompanijaVozilaService;
}());
exports.KompanijaVozilaService = KompanijaVozilaService;


/***/ }),

/***/ "./src/app/service/vozila/vozilo.service.ts":
/***/ (function(module, exports, __webpack_require__) {

"use strict";

var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
Object.defineProperty(exports, "__esModule", { value: true });
var core_1 = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
var http_1 = __webpack_require__("./node_modules/@angular/common/esm5/http.js");
var VoziloService = /** @class */ (function () {
    function VoziloService(http) {
        this.http = http;
    }
    /*addToRent(id: number, idRent: number): Observable<Vozilo[]> {
      return this.http.get<Vozilo[]>(`/api/rentacarovi/${idRent}/dodajURentVozilo/${id}`);
    }*/
    VoziloService.prototype.findOne = function (kompanijaid, garazaid, id) {
        return this.http.get("/kompanije-vozila/" + kompanijaid + "/garaze/" + garazaid + "/vozila/" + id);
    };
    VoziloService.prototype.findAll = function (kompanijaid, garazaid) {
        return this.http.get("/kompanije-vozila/" + kompanijaid + "/garaze/" + garazaid + "/vozila/");
    };
    /*findAllVozilaToAdd(): Observable<Vozilo[]> {
      return this.http.get<Vozilo[]>(`/api/rentacarovi/svaVozilaKojaSeMoguDodati`);
    }
  
    findVozilaForRent(id: number):Observable<Vozilo[]> {
      return this.http.get<Vozilo[]>(`/api/rentacarovi/${id}/prikazVozila`);
    }*/
    VoziloService.prototype.deleteVozilo = function (kompanijaid, garazaid, id) {
        return this.http.delete("/kompanije-vozila/" + kompanijaid + "/garaze/" + garazaid + "/vozila/" + id);
    };
    // deleteVoziloFromRent(id: number): Observable<{}> {
    //   return this.http.delete(`/api/vozila/${id}/deleteFromRent`);
    // }
    VoziloService.prototype.updateVozilo = function (kompanijaid, garazaid, id, vozilo) {
        return this.http.put("/kompanije-vozila/" + kompanijaid + "/garaze/" + garazaid + "/vozila", vozilo);
    };
    VoziloService.prototype.addVozilo = function (kompanijaid, garazaid, vozilo) {
        return this.http.post("/kompanije-vozila/" + kompanijaid + "/garaze/" + garazaid + "/vozila", vozilo);
    };
    VoziloService = __decorate([
        core_1.Injectable(),
        __metadata("design:paramtypes", [http_1.HttpClient])
    ], VoziloService);
    return VoziloService;
}());
exports.VoziloService = VoziloService;


/***/ }),

/***/ "./src/environments/environment.ts":
/***/ (function(module, exports, __webpack_require__) {

"use strict";

// The file contents for the current environment will overwrite these during build.
// The build system defaults to the dev environment which uses `environment.ts`, but if you do
// `ng build --env=prod` then `environment.prod.ts` will be used instead.
// The list of which env maps to which file can be found in `angular-cli.json`.
Object.defineProperty(exports, "__esModule", { value: true });
exports.environment = {
    production: false
};


/***/ }),

/***/ "./src/main.ts":
/***/ (function(module, exports, __webpack_require__) {

"use strict";

Object.defineProperty(exports, "__esModule", { value: true });
__webpack_require__("./src/polyfills.ts");
var platform_browser_dynamic_1 = __webpack_require__("./node_modules/@angular/platform-browser-dynamic/esm5/platform-browser-dynamic.js");
var core_1 = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
var environment_1 = __webpack_require__("./src/environments/environment.ts");
var app_module_1 = __webpack_require__("./src/app/app.module.ts");
if (environment_1.environment.production) {
    core_1.enableProdMode();
}
platform_browser_dynamic_1.platformBrowserDynamic().bootstrapModule(app_module_1.AppModule);


/***/ }),

/***/ "./src/polyfills.ts":
/***/ (function(module, exports, __webpack_require__) {

"use strict";

Object.defineProperty(exports, "__esModule", { value: true });
// This file includes polyfills needed by Angular 2 and is loaded before
// the app. You can add your own extra polyfills to this file.
__webpack_require__("./node_modules/core-js/es6/symbol.js");
__webpack_require__("./node_modules/core-js/es6/object.js");
__webpack_require__("./node_modules/core-js/es6/function.js");
__webpack_require__("./node_modules/core-js/es6/parse-int.js");
__webpack_require__("./node_modules/core-js/es6/parse-float.js");
__webpack_require__("./node_modules/core-js/es6/number.js");
__webpack_require__("./node_modules/core-js/es6/math.js");
__webpack_require__("./node_modules/core-js/es6/string.js");
__webpack_require__("./node_modules/core-js/es6/date.js");
__webpack_require__("./node_modules/core-js/es6/array.js");
__webpack_require__("./node_modules/core-js/es6/regexp.js");
__webpack_require__("./node_modules/core-js/es6/map.js");
__webpack_require__("./node_modules/core-js/es6/set.js");
__webpack_require__("./node_modules/core-js/es6/reflect.js");
__webpack_require__("./node_modules/core-js/es7/reflect.js");
__webpack_require__("./node_modules/zone.js/dist/zone.js");


/***/ }),

/***/ 0:
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__("./src/main.ts");


/***/ })

},[0]);
//# sourceMappingURL=main.bundle.js.map