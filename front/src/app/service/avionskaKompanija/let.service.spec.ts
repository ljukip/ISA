import { TestBed, inject } from '@angular/core/testing';

import { LetService } from './let.service';

describe('LetService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [LetService]
    });
  });

  it('should be created', inject([LetService], (service: LetService) => {
    expect(service).toBeTruthy();
  }));
});
