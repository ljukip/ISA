import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PrikazSedistaComponent } from './prikaz-sedista.component';

describe('PrikazSedistaComponent', () => {
  let component: PrikazSedistaComponent;
  let fixture: ComponentFixture<PrikazSedistaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PrikazSedistaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PrikazSedistaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
