import { TestBed, inject } from '@angular/core/testing';

import { GarazaService } from './garaza.service';

describe('GarazaService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [GarazaService]
    });
  });

  it('should be created', inject([GarazaService], (service: GarazaService) => {
    expect(service).toBeTruthy();
  }));
});
