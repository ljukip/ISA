import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PrikazSobaComponent } from './prikaz-soba.component';

describe('PrikazSobaComponent', () => {
  let component: PrikazSobaComponent;
  let fixture: ComponentFixture<PrikazSobaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PrikazSobaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PrikazSobaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
