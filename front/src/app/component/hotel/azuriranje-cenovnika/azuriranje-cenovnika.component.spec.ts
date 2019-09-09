import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AzuriranjeCenovnikaComponent } from './azuriranje-cenovnika.component';

describe('AzuriranjeCenovnikaComponent', () => {
  let component: AzuriranjeCenovnikaComponent;
  let fixture: ComponentFixture<AzuriranjeCenovnikaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AzuriranjeCenovnikaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AzuriranjeCenovnikaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
