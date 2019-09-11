import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PrikazMapeComponent } from './prikaz-mape.component';

describe('PrikazMapeComponent', () => {
  let component: PrikazMapeComponent;
  let fixture: ComponentFixture<PrikazMapeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PrikazMapeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PrikazMapeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
