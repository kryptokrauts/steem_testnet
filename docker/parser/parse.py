import json
import sys
from pprint import pprint

if len(sys.argv) < 4:
	print('provide public key file, private key file and account name')
	sys.exit()
else:
	print('[debug] using files - public: ',sys.argv[1],', private: ',sys.argv[2])

data = json.load(open(sys.argv[1]))

ownerKey = data['owner']['key_auths'][0][0]
activeKey = data['active']['key_auths'][0][0]
postingKey = data['posting']['key_auths'][0][0]
memoKey = data['memo_key']

#print(ownerKey);
#print(activeKey);
#print(postingKey);
#print(memoKey);

data = json.load(open(sys.argv[2]))

print('Account: ',sys.argv[3])

for key in data:		
	if ownerKey == key[0]:
		print('ownerKey;{};{}'.format(ownerKey,key[1]))
	elif activeKey == key[0]:
		print('activeKey;{};{}'.format(activeKey,key[1]))
	elif postingKey == key[0]:
		print('postingKey;{};{}'.format(postingKey,key[1]))
	elif memoKey == key[0]:
		print('memoKey;{};{}'.format(memoKey,key[1]))
	else:
		print('otherKey;{};{}'.format(key[0],key[1]))
