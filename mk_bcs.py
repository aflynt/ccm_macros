import math as m

def get_str_from_boundary(boundary):
    num      = boundary[0]
    type     = boundary[1]
    p1_val   = boundary[2]
    p1_units = boundary[3]
    p2_val   = boundary[4]
    p2_units = boundary[5]
    comment  = boundary[6]
    s = ''
    s += f'{num:2d} '     
    s += f'{type:s} '     
    s += f'{p1_val:12.4f} '
    s += f'{p1_units:5s} ' 
    s += f'{p2_val:12.4f} '
    s += f'{p2_units:1s} '
    s += f'# {comment:s}\n'
    return s

def write_boundaries(ofname, boundaries):
    
    lines = [get_str_from_boundary(b) for b in boundaries]
    lines[-1] = lines[-1].rstrip()

    with open(ofname, 'w') as f:
        f.writelines(lines)

# TEMPS (deg. F)
T_inlet = 1450.0
T_annulus = 120.0
T_exhaust = 3800.0
T_backflow = 1520.3

# ROOM CONVECTION
T_infinity = 110.0
h_room = 1.0

# MDOT (lbm/s)
mdot_inlet   = 120.0 / (2.0 * m.pi)
mdot_annulus =   6.0 / (2.0 * m.pi)

# PRESSURES (PSI)
p_atm = 101325.0 / 6894.76  # psi
p_center  = 1000.0 - p_atm  # psi
p_annulus = 1050.0 - p_atm  # psi
p_exhaust =  950.0 - p_atm  # psi

# FLUX (W/m^2)
q_flux    = -631000.0       # W/m^2

ofname = "boundaries.txt"

boundaries = [
    # 0      1         2          3        4        5      6
    ( 2 , "mdot", mdot_inlet,   "lb/s", T_inlet  , "F", "center  inlet"),
    ( 3 , "mdot", mdot_annulus, "lb/s", T_annulus, "F", "annular inlet"),
    ( 4 , "mdot", mdot_inlet,   "lb/s", T_exhaust, "F", "exhaust inlet"),

    ( 5 , "pres", p_center,  "psi", T_inlet   , "F", "center  exit"),
    ( 6 , "pres", p_annulus, "psi", T_annulus , "F", "annular exit"),
    ( 7 , "pres", p_exhaust, "psi", T_backflow, "F", "exhaust exit"),

    ( 8 , "temp", T_inlet   ,     "F",    0.0, "X", "comb casing"),
    ( 9 , "conv", T_infinity,     "F", h_room, "X", "TFL OD Wall"),
    (10 , "flux", q_flux,     "W/m^2",    0.0, "X", "exhaust duct OD"),
]

write_boundaries(ofname, boundaries)





