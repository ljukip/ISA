import { TestBed, inject } from '@angular/core/testing';

import { KompanijaVozilaService } from './kompanija-vozila.service';

describe('KompanijaVozilaService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [KompanijaVozilaService]
    });
  });

  it('should be created', inject([KompanijaVozilaService], (service: KompanijaVozilaService) => {
    expect(service).toBeTruthy();
  }));
});
