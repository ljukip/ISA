import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PrikazHotelaComponent } from './prikaz-hotela.component';

describe('PrikazHotelaComponent', () => {
  let component: PrikazHotelaComponent;
  let fixture: ComponentFixture<PrikazHotelaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PrikazHotelaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PrikazHotelaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
