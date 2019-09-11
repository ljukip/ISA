import { TestBed, inject } from '@angular/core/testing';

import { RezervacijeService } from './rezervacije.service';

describe('RezervacijeService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [RezervacijeService]
    });
  });

  it('should be created', inject([RezervacijeService], (service: RezervacijeService) => {
    expect(service).toBeTruthy();
  }));
});
