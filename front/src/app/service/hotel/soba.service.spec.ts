import { TestBed, inject } from '@angular/core/testing';

import { SobaService } from './soba.service';

describe('SobaService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [SobaService]
    });
  });

  it('should be created', inject([SobaService], (service: SobaService) => {
    expect(service).toBeTruthy();
  }));
});
