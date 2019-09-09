import { TestBed, inject } from '@angular/core/testing';

import { OpcijaService } from './opcija.service';

describe('OpcijaService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [OpcijaService]
    });
  });

  it('should be created', inject([OpcijaService], (service: OpcijaService) => {
    expect(service).toBeTruthy();
  }));
});
