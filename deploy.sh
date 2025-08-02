#!/bin/bash

# Backend 배포 스크립트
# 위치: backend 레포의 deploy.sh

echo "=== Backend 배포 시작 ==="

# 최신 코드 가져오기
git pull origin main

# Docker 이미지 빌드
docker build -t pd-test-backend:latest .

# 상위 디렉토리로 이동하여 docker-compose 실행
cd ..
docker-compose stop backend
docker-compose rm -f backend
docker-compose up -d backend

# 로그 확인
echo "=== Backend 로그 ==="
docker-compose logs --tail=50 backend

echo "=== Backend 배포 완료 ==="
