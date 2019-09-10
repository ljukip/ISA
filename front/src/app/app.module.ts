import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule, Routes } from '@angular/router';
import { NgxPaginationModule } from 'ngx-pagination';
import { AppComponent } from './app.component';
import { RatingModule } from "ngx-rating";
import { OwlDateTimeModule, OwlNativeDateTimeModule } from 'ng-pick-datetime';
import { HInterceptorService } from './h-interceptor.service';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import {DropdownModule} from "ngx-dropdown";
import {TabsModule} from "ngx-tabs";
import { NgMultiSelectDropDownModule } from 'ng-multiselect-dropdown';
import { AuthService } from './auth.service';
import { Ng5SliderModule } from 'ng5-slider';
import { PageNotFoundComponent } from './component/obavestenja/page-not-found/page-not-found.component';
import { PrikazVozilaComponent } from './component/vozila/prikaz-vozila/prikaz-vozila.component';
import { PrikazKompanijaVozilaComponent } from './component/vozila/prikaz-kompanija-vozila/prikaz-kompanija-vozila.component';
import { AzuriranjeVozilaComponent } from './component/vozila/azuriranje-vozila/azuriranje-vozila.component';
import { AzuriranjeKompanijeVozilaComponent } from './component/vozila/azuriranje-kompanije-vozila/azuriranje-kompanije-vozila.component';
import { VoziloService } from './service/vozila/vozilo.service';
import { KompanijaVozilaService } from './service/vozila/kompanija-vozila.service';
import { PrikazGarazaComponent } from './component/vozila/prikaz-garaza/prikaz-garaza.component';
import { GarazaService } from './service/vozila/garaza.service';
import { AzuriranjeGarazeComponent } from './component/vozila/azuriranje-garaze/azuriranje-garaze.component';
import { PrikazHotelaComponent } from './component/hotel/prikaz-hotela/prikaz-hotela.component';
import { AzuriranjeHotelaComponent } from './component/hotel/azuriranje-hotela/azuriranje-hotela.component';
import { AzuriranjeOpcijaComponent } from './component/hotel/azuriranje-opcija/azuriranje-opcija.component';
import { PrikazOpcijaComponent } from './component/hotel/prikaz-opcija/prikaz-opcija.component';
import { PrikazSobaComponent } from './component/hotel/prikaz-soba/prikaz-soba.component';
import { AzuriranjeSobaComponent } from './component/hotel/azuriranje-soba/azuriranje-soba.component';
import { HotelService } from './service/hotel/hotel.service';
import { SobaService } from './service/hotel/soba.service';
import { OpcijaService } from './service/hotel/opcija.service';
import { PrikazCenovnikaComponent } from './component/hotel/prikaz-cenovnika/prikaz-cenovnika.component';
import { AzuriranjeCenovnikaComponent } from './component/hotel/azuriranje-cenovnika/azuriranje-cenovnika.component';
import { CenovnikService } from './service/hotel/cenovnik.service';



const appRoutes: Routes = [
  /*{ path: 'record/:id', component: RecordDetailsComponent },
  { path: 'main', component: MainComponent },
  { path: '', redirectTo: 'main', pathMatch: 'full' },*/

  // ----------------------------------------rent a car
  { path: 'kompanije-vozila', component: PrikazKompanijaVozilaComponent },
  { path: 'kompanije-vozila/add', component: AzuriranjeKompanijeVozilaComponent },
  { path: 'kompanije-vozila/add/:id', component: AzuriranjeKompanijeVozilaComponent },
  
  { path: 'kompanije-vozila/:kompanija-id/garaze', component: PrikazGarazaComponent },
  { path: 'kompanije-vozila/:kompanija-id/garaze/add', component: AzuriranjeGarazeComponent },
  { path: 'kompanije-vozila/:kompanija-id/garaze/add/:garaza-id', component: AzuriranjeGarazeComponent },

  { path: 'kompanije-vozila/:kompanija-id/garaze/:garaza-id/vozila', component: PrikazVozilaComponent },
  { path: 'kompanije-vozila/:kompanija-id/garaze/:garaza-id/vozila/add', component: AzuriranjeVozilaComponent },
  { path: 'kompanije-vozila/:kompanija-id/garaze/:garaza-id/vozila/add/:id', component: AzuriranjeVozilaComponent },


  // --------------------------------------------- hotel
  { path: 'hoteli', component: PrikazHotelaComponent },
  { path: 'hoteli/add', component: AzuriranjeHotelaComponent },
  { path: 'hoteli/add/:id', component: AzuriranjeHotelaComponent },

  { path: 'hoteli/:hotel-id/opcije', component: PrikazOpcijaComponent },
  { path: 'hoteli/:hotel-id/opcije/add', component: AzuriranjeOpcijaComponent },
  { path: 'hoteli/:hotel-id/opcije/add/:opcija-id', component: AzuriranjeOpcijaComponent },
  
  { path: 'hoteli/:hotel-id/sobe', component: PrikazSobaComponent },
  { path: 'hoteli/:hotel-id/sobe/add', component: AzuriranjeSobaComponent },
  { path: 'hoteli/:hotel-id/sobe/add/:soba-id', component: AzuriranjeSobaComponent },

  { path: 'hoteli/:hotel-id/sobe/:soba-id/cenovnici', component: PrikazCenovnikaComponent },
  { path: 'hoteli/:hotel-id/sobe/:soba-id/cenovnici/add', component: AzuriranjeCenovnikaComponent },
  { path: 'hoteli/:hotel-id/sobe/:soba-id/cenovnici/add/:id', component: AzuriranjeCenovnikaComponent },
  
 
  { path: 'putanja', component: PageNotFoundComponent },
  { path: '**', component: PageNotFoundComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    PageNotFoundComponent,
	PrikazVozilaComponent,
    PrikazKompanijaVozilaComponent,
    AzuriranjeVozilaComponent,
    AzuriranjeKompanijeVozilaComponent,
    PrikazGarazaComponent,
    AzuriranjeGarazeComponent,
    PrikazHotelaComponent,
    AzuriranjeHotelaComponent,
    AzuriranjeOpcijaComponent,
    PrikazOpcijaComponent,
    PrikazSobaComponent,
    AzuriranjeSobaComponent,
    PrikazCenovnikaComponent,
    AzuriranjeCenovnikaComponent,
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    HttpModule,
    HttpClientModule,
    NgxPaginationModule,
    RatingModule,
    DropdownModule,
    TabsModule,
    OwlDateTimeModule,
    OwlNativeDateTimeModule,
    NgMultiSelectDropDownModule.forRoot(),
    Ng5SliderModule,
    RouterModule.forRoot(
      appRoutes,
      { enableTracing: false, useHash: true } // <-- debugging purposes only
    )
  ],
  providers: [ //registrujem servise obaveznoo!!!!!!
    AuthService,
	VoziloService,
    KompanijaVozilaService,
    GarazaService,
    HotelService,
    SobaService,
    OpcijaService,
    CenovnikService,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: HInterceptorService,
      multi: true
    },
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
