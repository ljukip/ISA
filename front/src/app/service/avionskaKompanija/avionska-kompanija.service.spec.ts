import { TestBed, inject } from '@angular/core/testing';

import { AvionskaKompanijaService } from './avionska-kompanija.service';

describe('AvionskaKompanijaService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [AvionskaKompanijaService]
    });
  });

  it('should be created', inject([AvionskaKompanijaService], (service: AvionskaKompanijaService) => {
    expect(service).toBeTruthy();
  }));
});
