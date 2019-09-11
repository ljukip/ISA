import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AzuriranjeLetaComponent } from './azuriranje-leta.component';

describe('AzuriranjeLetaComponent', () => {
  let component: AzuriranjeLetaComponent;
  let fixture: ComponentFixture<AzuriranjeLetaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AzuriranjeLetaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AzuriranjeLetaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
