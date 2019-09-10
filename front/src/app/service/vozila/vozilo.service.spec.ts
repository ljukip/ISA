import { TestBed, inject } from '@angular/core/testing';

import { VoziloService } from './vozilo.service';

describe('VoziloService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [VoziloService]
    });
  });

  it('should be created', inject([VoziloService], (service: VoziloService) => {
    expect(service).toBeTruthy();
  }));
});
