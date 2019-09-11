import { TestBed, inject } from '@angular/core/testing';

import { SedisteService } from './sediste.service';

describe('SedisteService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [SedisteService]
    });
  });

  it('should be created', inject([SedisteService], (service: SedisteService) => {
    expect(service).toBeTruthy();
  }));
});
