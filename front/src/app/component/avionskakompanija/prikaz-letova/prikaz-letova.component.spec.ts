import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PrikazLetovaComponent } from './prikaz-letova.component';

describe('PrikazLetovaComponent', () => {
  let component: PrikazLetovaComponent;
  let fixture: ComponentFixture<PrikazLetovaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PrikazLetovaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PrikazLetovaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
