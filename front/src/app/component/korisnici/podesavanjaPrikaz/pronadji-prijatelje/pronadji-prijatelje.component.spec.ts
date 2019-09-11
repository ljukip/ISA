import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PronadjiPrijateljeComponent } from './pronadji-prijatelje.component';

describe('PronadjiPrijateljeComponent', () => {
  let component: PronadjiPrijateljeComponent;
  let fixture: ComponentFixture<PronadjiPrijateljeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PronadjiPrijateljeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PronadjiPrijateljeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
