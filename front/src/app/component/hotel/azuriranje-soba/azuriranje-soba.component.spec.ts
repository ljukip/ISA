import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AzuriranjeSobaComponent } from './azuriranje-soba.component';

describe('AzuriranjeSobaComponent', () => {
  let component: AzuriranjeSobaComponent;
  let fixture: ComponentFixture<AzuriranjeSobaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AzuriranjeSobaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AzuriranjeSobaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
