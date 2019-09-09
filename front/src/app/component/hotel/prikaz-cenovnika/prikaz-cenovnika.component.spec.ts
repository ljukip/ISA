import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PrikazCenovnikaComponent } from './prikaz-cenovnika.component';

describe('PrikazCenovnikaComponent', () => {
  let component: PrikazCenovnikaComponent;
  let fixture: ComponentFixture<PrikazCenovnikaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PrikazCenovnikaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PrikazCenovnikaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
