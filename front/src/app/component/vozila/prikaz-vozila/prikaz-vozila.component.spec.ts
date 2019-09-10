import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PrikazVozilaComponent } from './prikaz-vozila.component';

describe('PrikazVozilaComponent', () => {
  let component: PrikazVozilaComponent;
  let fixture: ComponentFixture<PrikazVozilaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PrikazVozilaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PrikazVozilaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
